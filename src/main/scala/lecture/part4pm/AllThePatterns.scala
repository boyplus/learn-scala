package lecture.part4pm

import exercise.{Cons, MyList, Empty}

object AllThePatterns extends App {
  // 1 - constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "THE Scala"
    case true => "The truth"
    case AllThePatterns => "A singleton object"
  }

  // 2 - match anything
  // 2.1 wildcard
  val matchAnything = x match {
    case _ =>
  }

  // 2.2 variable
  val matchVariable = x match {
    case something => s"I've found $something"
  }

  // 3 - tuples
  val aTuple = (1,2)
  val matchATuple = aTuple match {
    case (1,1) => ""
    case (something, 2) => s"I've found $something"
  }

  val nestedTuple = (1, (2,3))
  val matchANestedTuple = nestedTuple match {
    case (_, (2, v)) => "matching"
  }

  // PMs can be nested

  // 4 - case classes - constructor pattern
  // PMs can be nested with CCs as well
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList = aList match {
    case Empty => "Empty"
    case Cons(head, Cons(subhead, subtail)) => s"I've found $head, $subhead, $subtail"
  }

  // 5 - list patterns
  val aStandardList = List(1,2,3,42)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => "" // extractor - advanced
    case List(1, _*) => "" // list of arbitrary length - advanced
    case 1 :: List(_) => "" // infix pattern
    case List(1,2,3) :+ 42 => "" // infix pattern
  }

  // 6 - type soecifiers
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => "It is List[Int]" // explicit type specifier
    case _ => ""
  }

  // 7 - name binding
  val nameBindingMatch = aList match {
    case notEmptyList @ Cons(_,_) => "" // name binding => use the name later (here)
    case Cons(1, rest @ Cons(2, _)) => "" // name binding inside nested patterns
  }

  // 8 - multi-patterns
  val multiPattern = aList match {
    case Empty | Cons(0, _) => "" // compound pattern (multi-pattern)
    case _ => ""
  }

  // 9 - if guards
  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 => ""
  }

  // ALL.

  /*
    Question
   */

  val numbers = List(1,2,3)
  val numbersMatch = numbers match {
    case listOfStrings: List[String] => "a list of strings"
    case listOfNumbers: List[Int] => "a list of numbers"
    case _ => ""
  }
  println(numbersMatch)
  // JVM trick question
  // Generic was introduced in java5, for backward compatibility, the generic types are deleted from type match
}
