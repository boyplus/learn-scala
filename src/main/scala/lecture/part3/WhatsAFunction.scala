package lecture.part3

object WhatsAFunction extends App {

  // DREAM: use functions as first class elements
  // problem: OOP

  // doubler is a function-like class
  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  // call apply method
  println(doubler(2))


  // function types = Function1[A, B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }
  println(stringToIntConverter("12"))


  val adder: ((Int,Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }
  println(adder(2,3))

  // Function types Function2[A,B,R] === (A,B) => R
  // All Scala functions are objects

  /*
    1. a function which takes 2 strings and concatenates them
    2. transform the MyPredicate and MyTransformer into function types
    3. define a function which takes an argument an int and return another function which takes an int and returns an int
      - what's the type of this function
      - how to do it
   */

  val concattor: ((String, String) => String) = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a+b
  }
  println(concattor("boy", "plus"))
}

trait MyFunction[A, B] {
  def apply(element: A): B
}
