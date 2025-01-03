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

    !!! careful with mapping keys

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

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    network + (person -> Set())
  }

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    // update they value of the map to add B into the friends set of A
    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    // remove B from friends set of A, and remove A from friends set of B
    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    // need to remove person from this friend set first
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")
  println(network)
  println(friend(network, "Bob", "Mary"))
  println(unfriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
  println(remove(friend(network, "Bob", "Mary"), "Bob"))


  // Jim, Bob, Mary
  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Bob", "Jim")
  val testNet = friend(jimBob, "Bob", "Mary")

  println(testNet)

  def nFriend(network: Map[String, Set[String]], person: String): Int =
    if(!network.contains(person)) 0
    else network(person).size

  println(nFriend(testNet, "Bob"))

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(testNet))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int =
    network.count(_._2.isEmpty)

  println(nPeopleWithNoFriends(testNet))
}
