package lecture.part3

import scala.util.Random

object Sequences extends App {
  // Seq
  val aSequence = Seq(1,3,2,4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2)) // get element at index number 2
  println(aSequence ++ Seq(7, 6, 5)) // concat sqe
  println(aSequence.sorted)

  // Ranges
  val aRange: Seq[Int] = 1 until 10
  aRange.foreach(print)
  println()

  (1 to 3).foreach(x => print("Hello "))
  println()
  // lists
  val aList = List(1,2,3)
  val prepended = 42 +: aList :+ 89
  println(prepended)

  // fill is a curry function
  val apples5 = List.fill(5)("apple")
  println(apples5)

  // mkString -> separator between elements
  println(aList.mkString("-|-"))


  // arrays
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](3) // ofDim = Allocate the size with default value
  // Primitive type (Int, Boolean) -> default value is 0, false
  // Non-primitive type e.g. String -> default value is null
  threeElements.foreach(println)

  // mutation
  numbers(2) = 0 // syntax sugar for numbers.update(2,0) -> update the element at index 2 to be 0
  println(numbers.mkString(" "))

  // arrays and seq
  val numbersSeq: Seq[Int] = numbers // numbers is Array -> implicit conversion, we can convert array to sequence
  println(numbersSeq)

  // vectors
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // vector vs list
  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      // update collection at random index to be random value
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns // average times
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // keeps reference to tail
  // updating an element in the middle takes long
  println(getWriteTime(numbersList))

  // depth of the tree is small
  // needs to replace an entire 32-element chunk
  println(getWriteTime(numbersVector))
}
