package lecture.part1basic

object Expression extends App {

  val x = 1 + 2 // expression
  println(x)

  println(2 + 3 * 4)
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // also works with -= *= /= ...... these are all side effects
  println(aVariable)


  // Instructions (DO) VS Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // IF EXPRESSION
  println(aConditionedValue)

  println(if(aCondition) 5 else 3)
  println(1+3)

  var i = 0
  while(i < 10){
    print(i)
    i += 1
  }
  println()

  // NEVER WRITE THIS AGAIN.


  // Everything in Scala is an Expression!

  val aWeirdValue: Unit = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // side effects: println, while, reassigning -> return Unit

  // Code blocks
  // The value of the block is the value of its last expression
  val aCodeBlock = {
    val y = 2
    val z = y+1
    // last expression
    if(z > 2) "hello" else "goodbye"
  }


  // Expressions vs Instructions
  // Expressions are evaluated, instructions are executed
  // In Scala, we think as expressions


  // Do not use while loop in scala

  // 1. difference between "hello world" vs println("hello world") ?
  // The first one is the value of type String, the second is expression (side effect which return Unit)

  // 2.
  val someValue = {
    2 < 3
  }
  // true

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  // 42
}
