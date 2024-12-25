package lecture.part2oop

object Generics extends App {
  // Generic class
  class MyList[+A] {
    // use type A
    // B is a super type of A
    def add[B >: A](element: B): MyList[B] = ???

    /*
      A = cat
      B = Animal
     */
  }

  class MyMap[Key, Value] {

  }

  // trait also can use generic type as well

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOnIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? HARD QUESTION => we return a list of Animal

  // 2. NO = INVARIANCE
  class InvariantList[A]

  // cannot do this
  //  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]


  // 3. Hell, no!, CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  // A is subtype of animal
  class Cage[A <: Animal] (animal: A)
  val cage = new Cage(new Dog)


  class Car
//  val newCage = new Cage(new Car)
}
