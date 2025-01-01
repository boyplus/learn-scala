package lecture.part3

object MapFlatmapFilterFor extends App {
  // creating a list from apply method in List companion object
  val list = List(1,2,3)
  println(list)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  // print all combinations between two lists
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colors = List("black", "white")
  // Output -> List("a1", "a2", "" ,..., "d4")

  // My solution
  val pairing = (a: Char, b: List[Int]) => b.map(x => a + "" + x)
  val output = chars.flatMap(c => pairing(c, numbers))
  println(output)

  // Author solution
  val combinations = numbers.flatMap(n => chars.map(c => c + "" + n))
  println(combinations)

  // iterating
  val anotherCombinations = numbers.flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  println(anotherCombinations)

  // foreach
  list.foreach(println)

  // for-comprehensions -> for flatMap chain and map at the end
  // more readable and use in practice
  val forCombinations = for {
    n <- numbers if n % 2 == 0 // we can have "guard"
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color

  println(forCombinations)

  // can have side effects as well
  for {
    n <- numbers
  } println(n)

  // syntax overload
  list.map { x =>
    x * 2
  }

  /*
    1. MyList supports for comprehensions ?
      map(f: A => B) => MyList[B]
      filter(p: A => Boolean) => MyList[A]
      flatMap(f: A => MyList[B]) => MyList[B]
    2. A small collection of at most ONE element - Maybe[+T]
      - map, flatMap, filter
   */
}
