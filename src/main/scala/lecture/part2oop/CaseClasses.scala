package lecture.part2oop

object CaseClasses extends App {
  /*
    equals, hashCode, toString
   */

  case class Person(name: String, age: Int)
  // 1. class parameter are fields (for normal class, we need to add val)
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  // println(instance) = println(instance.toString) -> syntactic sugar
  println(jim.toString)
  println(jim)

  // 3. equals and hashCode implement OOTB
  // for normal class, equal is comparing address
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. CCs have handy copy method
  val jim3 = jim.copy(age = 45) // create a new instance of case class
  println(jim3)

  // 5. CCs have companion objects
  val thePerson = Person

  // in practice, we don't need new keyword for creating instance of case class
  val mary = Person("Mary", 23)

  // 6. CCs are serializable
  // Akka


  // 7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }


  /*
    Expand MyList - use case classes and case objects
   */
}

