package lecture.part2oop

object AnonymousClasses extends App{
  abstract class Animal {
    def eat: Unit
  }

  // Anonymous class

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahaha")
  }

  /*
    equivalent with
    class AnonymousClasses$$anon$1 extends Animal {
      override def eat: Unit = println("ahahahaha")
    }
    val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass)

  class Person(name: String){
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help ?")
  }

  // Anonymous class works for both abstract and non-abstract class
  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be service ?")
  }

  // Rules
  // 1. pass in required constructor arguments if needed
  // 2. implement all abstract fields/methods
}
