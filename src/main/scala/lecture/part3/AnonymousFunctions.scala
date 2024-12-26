package lecture.part3

object AnonymousFunctions extends App {
  // old way
  //  val doubler =  new Function1[Int, Int] {
  //    override def apply(x: Int) = x
  //  }

  // new way -> syntactic sugar
  // anonymous function (LAMBDA)
  // val tempDoubler = (x: Int) => x*2
  val doubler: Int => Int = x => x * 2

  // multiple params in a lambda
  val adder = (a: Int, b:Int) => a + b
  val shortAdder: (Int, Int) => Int = (a, b) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  // careful, for lambda function, always need to have () to call
  println(justDoSomething) // function itself
  println(justDoSomething()) // call

  // curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MORE syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a,b) => a + b

  /*
    1. MyList: replace all FUnctionX calls with lambdas
    2. Rewrite the "special" adder as an anonymous function
   */

  val superAdder = (x: Int) => (y: Int) => x + y
  println(superAdder(3)(2))

  /*
    Takeaways
    Instead of passing anonymous FunctionX instance every time
    - cumbersome
    - still object-oriented

   */
}
