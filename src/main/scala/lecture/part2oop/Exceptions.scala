package lecture.part2oop

object Exceptions extends App {
  val x: String = null
  //  println(x.length)
  // this ^^ will crash with a Null pointer exception

  // throwing and catching exceptions

  // 1. How to throw exception
  // type is Nothing
  // NullPointerException is a class
  //  val aWeirdValue = throw new NullPointerException

  // throwable classes extends the Throwable class.
  // Exception and Error are the major Throwable subtypes

  // 2. How to catch exceptions
  def getInt(withException: Boolean): Int = {
    if (withException) throw new RuntimeException("No int for you")
    else 42
  }

  val potentialFail = try {
    // code that might throw
    getInt(true)
  } catch {
    case e: RuntimeException => 43
    case e: NullPointerException => 44
  } finally {
    // code that will get executed NO MATTER WHAT
    // optional
    // does not influence the return type of this expression
    // ise finally only for side effects
    println("finally")
  }

  println(potentialFail)

  // 3. How to define your own exceptions
  class MyException extends Exception
  val exception = new MyException
//  throw exception

  /*
    1. Crash your program with an OutOfMemoryError
    2. Crash with Stack Overflow Error
    3. PocketCalculator
      - add(x,y)
      - subtract(x,y)
      - multiply(x,y)
      - divide(x,y)

      Throw
        - OverflowException if add(x,y) exceeds INT.MAX_VALUE
        - OverflowException if subtract(x,y) exceeds INT.MIN_VALUE
        - MathCalculationException for division by 0
   */

  // OOM
  // var stringArray = new Array[Int](1000000000)

  // SO
//  def rec: Int = 1+ rec
//  val noLimit = rec

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if(x > 0 && y > 0 && result < 0) throw new OverflowException
      else if(x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if(x > 0 && y < 0 && result < 0)  throw new OverflowException
      else if(x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x*y
      if(x > 0 && y > 0 && result < 0) throw new OverflowException
      else if(x < 0 && y < 0 && result < 0) throw new OverflowException
      else if(x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if(x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if(y == 0) throw new MathCalculationException
      else x/y
    }
  }

//  println(PocketCalculator.add(Int.MaxValue, 10))
//  println(PocketCalculator.divide(3,0))


  // Take aways
  // 1. Throwing return Nothing
  val someValue = throw new RuntimeException()
}