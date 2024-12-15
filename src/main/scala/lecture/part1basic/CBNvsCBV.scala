package lecture.part1basic

object CBNvsCBV extends App {
  def calledByValue(x: Long): Unit = {
    println("by value "+ x)
    println("by value "+ x)
  }

  // call by name
  // the value of x will be determined by the argument each time
  // Which mean it delay the evaluation when there is reference to it
  def calledByName(x: => Long): Unit = {
    println("by name " + x)
    println("by name " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())


  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //  printFirst(infinit(), 34)

  // Parameter y is never used, so the program does not crash
  printFirst(34, infinite())


  // Takeaways
  // Call by value
  // 1. value is computed before call
  // 2. same value used everywhere

  // Call by name
  // 1. expression is pass literally
  // 2. expression is evaluated at every use within
}
