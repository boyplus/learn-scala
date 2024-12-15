package lecture.part1basic

object Functions extends App {
  // compiler can also infer type, no need to explicit
  def aFunction(a: String, b: Int) = {
    a + " " + b
  }

  println(aFunction("Hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())


  // For recursive function, it is needed to specify the return type
  def aRepeatedFunction(aString: String, n: Int): String = {
    if(n == 1) aString
    else aString + " " + aRepeatedFunction(aString, n - 1)
  }

  println(aRepeatedFunction("hello", 3))

  // When you need loop, use recursion!

  def aFunctionWithSideEffect(aString: String): Unit = println(aString)

  aFunctionWithSideEffect("Palooo")

  def aBigFunction(n: Int): Int = {
    def aSmallFunction(a: Int, b:Int): Int  = a + b
    aSmallFunction(n, n-1)
  }

  println(aBigFunction(3));


  /*
    1. A greeting function (name, age) => "Hi, my name is ... and I am ... years old
    2. Factorial function 1 * 2 * 3 * ... * n
    3. A fibonacci function
        f(1) = 1
        f(2) = 1
        f(n) = f(n-1) + f(n-2)
    4. Tests if a number is prime
   */

  def greeting(name: String, age: Int): String = "Hello, my name is " + name + " and I am " + age + " years old"

  def factorial(n: Int): Int = {
    if(n == 0) 1
    else n * factorial(n-1)
  }

  def fibonacci(n: Int): Int  = {
    if(n == 1 || n == 2) 1
    else fibonacci(n-1) + fibonacci(n-2)
  }

  def isPrime(n: Int): Boolean = {
    def helper(x: Int): Boolean = {
      if(x == 1) true
      else n % x != 0 && helper(x-1)
    }
    helper(n-1)
  }

  println(isPrime(15))
  println(isPrime(37))
  println(isPrime(37 * 17))
}
