package lecture.part2oop

object InheritanceAndTraits extends App {
  // Single class inheritance
  // private -> can access only on that class instance
  // protected -> can access only on the class itself/subclass but not from subclass instance
  class Animal {
    // with protected, eat is not accessible from Cat instance
    protected def eat = println("Eating")
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
}
