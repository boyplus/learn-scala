package lecture.part2oop

object AbstractDataTypes extends App {
  // abstract class -> cannot be instantiate, can have both abstract and non-abstract member
  abstract class Animal {
    val creatureType: String = "Wild"
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch")
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I am a croc and I am eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // trait vs abstract class
  // 1. traits do not have constructor parameters
  // 2. Multiple traits may be inherited by the same class
  // 3. traits = only behavior, abstract class = type of thing


  // Scala Type Hierarchy
  // scala.Any
}
