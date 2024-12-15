package lecture.part1basic

import scala.annotation.tailrec

object Recursion extends App {
  def factorial(n: Int): Int = {
    if(n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of "+ (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of "+ n)

      result
    }
  }

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if(x <= 1) accumulator
      else factorialHelper(x-1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression
    }
    factorialHelper(n, 1)
  }

  println(anotherFactorial(10))

  // When you need loop, use tail recursion

  /*
    1. Concatenate a string n times
    2. IsPrime function tail recursive
    3. Fibonacci function, tail recursive
   */

  def concat(str: String, n: Int): String = {
    @tailrec
    def concatHelper(result: String, x: Int): String = {
      if(x == 0) result
      else concatHelper(result + str, x-1)
    }

    concatHelper("", n)
  }

  println(concat("hello", 3))


  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeHelper(x: Int): Boolean = {
      if(x == 1) true
      else if(n % x == 0) false
      else isPrimeHelper(x-1)
    }

    isPrimeHelper(n-1)
  }

  println(isPrime(37))
  println(isPrime(39))

  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciHelper(a: Int, b: Int, x: Int): Int  = {
      if(x == n) a+b
      else fibonacciHelper(b, a+b, x+1)
    }
    if(n <= 2) 1
    else fibonacciHelper(1, 1, 3)
  }

  println(fibonacci(20))
}
