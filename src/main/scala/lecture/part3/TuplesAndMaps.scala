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
  val phonebook = Map(("Jim", 555), "Daniel" -> 789, "JIM" -> 9000).withDefaultValue(-1)
  // a-> b is sugar for (a, b)

  // map ops
  println(phonebook.contains("Jim"))
  println(phonebook("Jim"))
  println(phonebook("Mary")) // Map.apply with the key that does not exist will throw an exception

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phonebook + newPairing // because Map is immutable
  println(newPhonebook)

  // functions on maps
  // map, flatMap, filter

  // .map -> Transform Map to another Map
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // filter keys
  println(phonebook.view.filterKeys(x => x.startsWith("J")).toMap)

  // mapValues
  println(phonebook.view.mapValues(number => "0245-" + number).toMap)


  // conversion to other collections
  println(phonebook.toList)
  println(List(("Daniel", 555)).toMap)


  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

  /*
    1. What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900

    2. Overly simplified social network based on maps
    Person = String
    - add a person to the network
    - remove
    - friend (mutual)
    - unfriend

    - number of friends of a person
    - person with most friends
    - how many people have no friends
    - if there is a social connection between two people (direct or not)
   */
}
