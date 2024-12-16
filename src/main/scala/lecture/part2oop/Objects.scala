package lecture.part2oop

object Objects {
  // Scala does not have class level functionality (static)
  object Person { // type + its only instance
    // "static"/"class" level functionality
    val N_EYES = 2
    def canFly: Boolean = false
    
    // factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobie")
  }

  class Person(val name: String) {
    // instance-level functionality

  }
  // Companions

  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object is singleton instance

    // instance of class Person
    val mary = new Person("mary")
    val john = new Person("john")

    println(mary == john)


    // There is only one single object for Person
    // So it's equal
    val person1 = Person
    val person2 = Person
    println(person1 == person2)


    // This is not constructor of class Person
    // It is apply method from Person Object
    val bobie = Person(mary, john)

    // Scala Applications = Scala object with
    // def main(args: Array[String]): Unit
  }
}
