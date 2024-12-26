package lecture.part2oop

// can use alias by using => or as
import playground.{PrinceCharming, Cinderrella as Princess}

import java.util.Date
import java.sql.{Date => SqlDate}

// if the list is too long, we can use ._
// import playground._

object PackingAndImports extends App {
  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "RickTheJVM", 2018)

  // import the package
  val princes = new Princess // playground.Cinderella = fully qualified name

  // packages are in hierarchy
  // matching folders structure


  // scala specific
  // package object (from package.scala file)
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming


  // When the class name is the same between two packages
  // 1. use full name
  val date = new java.util.Date
  val sqlDate = new java.sql.Date(2018,5,4)

  // 2. use aliasing
  val anotherSqlDate = new SqlDate(2018, 5,4)


  // default imports -> we don't need to import them
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???


  /*
    Takeaways
    1. package = a group of definitions under the same name
      to use a definition
      - be in the same package
      - or import the package
    2. Best practice - mirror the file structure
    3. package objects hold standalone method/constants -> one per package


   */
}
