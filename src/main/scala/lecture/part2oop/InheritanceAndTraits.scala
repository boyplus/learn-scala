package lecture.part2oop

object InheritanceAndTraits extends App {
  // Single class inheritance
  // private -> can access only on that class instance
  // protected -> can access only on the class itself/subclass but not from subclass instance
  sealed class Animal {
    val creatureType = "wild"

    // with protected, eat is not accessible from Cat instance
    def eat = {
      println("Eating")
    }
  }

  // Animal is super of Cat
  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch


  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  // we can override val from the constructor directly
  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType = "domestic"
    override def eat = {
      // refer to method eat from super class
      super.eat
      println("crunch, crunch")
    }
  }

//  class Dog(dogType: String) extends Animal{
//    override val creatureType: String = "dogtype"
//  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)


  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat


  // overriding vs overloading

  // super -> refer to parent class

  // preventing overrides
  // 1. use final on member
  // 2. use final on the entire class -> another class cannot extend this class
  // 3. seal the class = extend classes in this file only, prevent extension in other files
}