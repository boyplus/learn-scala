package lecture.part4pm

object PatternsEverywhere extends App {
  // big idea #1

  try {
    // code
  } catch {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "Something else"
  }

  // catches are actually MATCHES
  /*
    try{
      // code
    } catch(e) {
      e match {
        case e: RuntimeException => "runtime"
        case npe: NullPointerException => "npe"
        case _ => "Something else"
      }
    }
   */

  // big idea #2
  val list = List(1,2,3,4)
  val evenOnes = for {
    x <- list if x % 2 == 0 // ?!
  } yield 10 * x
  println(evenOnes)

  // generators are alo based on pattern matching
  val tuples = List((1,2), (3,4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second
  println(filterTuples)
  // case classes, :: operators, ...
  
  // big idea #3
}
