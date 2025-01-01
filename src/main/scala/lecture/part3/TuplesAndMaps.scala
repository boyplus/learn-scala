package lecture.part3

object TuplesAndMaps extends App {
  // tuples = finite ordered "lists"
  val aTuple = (2, "hello, scala") // Tuple2[Int, String] = (Int, String) -> Syntactic sugar
  println(aTuple._1) // 2
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap) // ("hello, scala", 2)


  // Maps - keys -> values
  val aMap: Map[String, Int] = Map() //  call apply method

  // each element is tuple
  val phonebook = Map(("Jim", 555), "Daniel" -> 789)
  // a-> b is sugar for (a, b)

  // map ops
  println(phonebook.contains("Jim"))
  println(phonebook("Jim"))
  println(phonebook("Mary")) // Map.apply with the key that does not exist will throw an exception
}
