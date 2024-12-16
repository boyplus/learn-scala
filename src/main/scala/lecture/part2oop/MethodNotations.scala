package lecture.part2oop

import scala.language.postfixOps

object MethodNotations extends App {
  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name what the heck?"
    def isAlive: Boolean = true
    // () is important
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"


    def +(str: String): Person = new Person(s"$name ($str)", favoriteMovie)
    def unary_+ : Person  = new Person(name, favoriteMovie, age + 1)
    def learns(subject: String): String = s"$name learns $subject"
    def learnsScala: String = this learns "Scala"


    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
  }


  val marry =  new Person("Marry", "Inception")
  println(marry.likes("Inception"))
  println(marry likes "Inception") // equivalent
  // 1. Infix notation = operator notation (syntactic sugar)
  // Syntax: object method parameter -> for methods with only one parameter

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  // hangOutWith is operator between 2 things
  // we can even define method name as +,-, ...
  println(marry + tom)
  println(marry.+(tom))


  println(1 + 2)
  println(1.+(2))


  // All operators are methods
  // Akka actors have ! ?


  // 2. Prefix notation
  val x = -1 // - is unary operator (method) -> equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_prefix only work with - + ~ !


  println(!marry)
  println(marry.unary_!)


  // 3. Postfix notation
  println(marry.isAlive)
  println(marry isAlive)

  // Apply
  println(marry.apply())
  println(marry()) // equivalent


  /*
    1. Overload the + operator
        mary + "the rockstar" => new Person "Mary (the rockstar)"
    2. Add an age to the Person class
      Add a unary + operator => new Person with the age + 1
      +mary => mary with the age increment

    3. Add a "learns" method in the Person class => "Mary learns Scala"
       Add a learnScala method, calls learns method with "Scala"
       Use it in postfix notation

    4. Overload the apply method
      mary.apply(2) => Mary watched Inception 2 times
   */

  println((marry + "the rock star").apply())
  println((+marry).age)
  println(marry learnsScala)
  println(marry(10))
}
