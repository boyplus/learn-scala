package exercise

abstract class MyList[+A] {
  /*
    head = first element of the list
    tail = remainder of the list
    isEmpty = is this list empty
    add(int) => new list with this element added
    toString => a string representation of the list
   */

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  // higher-order functions -> either receive function as parameter or return function as result
  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  // concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]
}

// object can extend class
case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  // polymorphism
  def printElements: String =
    if(t.isEmpty) "" + h
    else "" + h + " " + t.printElements


  /*
    How filter work
    [1,2,3].filter(n % 2 == 0)
      [2,3].filter(n % 2 == 0)
      = new Cons(2, [3].filter(n%2 == 0))
      = new Cons(2, Empty.filter(n % 2 == 0))
      = new Cons(2, Empty)
   */
  def filter(predicate: A => Boolean): MyList[A] = {
    if(predicate(h)) new Cons(head, t.filter(predicate))
    else t.filter(predicate)
  }


  /*
    How map work
    [1,2,3].map(n * 2)
    = new Cons(2, [2,3].map(n * 2))
    = new Cons(2, new Cons(4, [3].map(n * 2)))
    = new Cons(2, new Cons(4, new Cons(6, Empty.map(n*2))))
    = new Cons(2, new Cons(4, new Cons(6, Empty)))
   */
  def map[B](transformer: A => B): MyList[B] = {
    new Cons[B](transformer(h), t.map(transformer))
  }

  /*
    How concat work
    [1,2] ++ [3,4,5]
    = new Cons(1, [2] ++ [3,4,5])
    = new Cons(1, new Cons(2), Empty ++ [3,4,5])
    = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))
   */
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)


  /*
    [1,2].flatMap(n => [n, n + 1])
    = [1,2] ++ [2].flatMap(n => [n, n+1])
    = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n,n+1])
    = [1,2] ++ [2,3] ++ Empty
    = [1,2,2,3]
   */
  def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }
}

//trait MyPredicate[-T] { // T => Boolean
//  def test(element: T): Boolean
//}
//
//trait MyTransformer[-A, B] { // A => B
//  def transform(element: A): B
//}



object ListTest extends App {
//  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
//  println(list.tail.head)
//  list.add(4)
//  println(list.head)
//  println(list.isEmpty)
//
//  println(list.toString)

  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val clonedListOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = new Cons(4, new Cons(5, Empty))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfIntegers.map(new Function1[Int,Int] {
    override def apply(element: Int): Int = element * 2
  }).toString)

  println(listOfIntegers.filter(new Function1[Int, Boolean]{
    override def apply(element: Int): Boolean = element % 2 == 0
  }).toString)

  println(listOfIntegers ++ anotherListOfIntegers)
  println(listOfIntegers.flatMap(new Function1[Int, MyList[Int]] {
    override def apply(element: Int): MyList[Int] = new Cons(element, new Cons(element + 1, Empty))
  }).toString)


  // as Cons is case class, no need to implement == method by ourselves
  println(listOfIntegers == clonedListOfIntegers)


  // transform MyPredicate and MyTransformer into function types
  val doubler: ((Int) => Int) = new Function[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }
}

