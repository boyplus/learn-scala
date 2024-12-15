package lecture.part1basic

object ValuesVariablesTypes extends App {
  // VALUES -> immutable
  val x: Int = 12

  // compiler can infer the type from the right hand side
  val y = 42
  println(y)

  // vals cannot be re-assigned
  // vals are immutable

  // ; is allowed in scala, but not needed
  val aString: String = "hello"
  val anotherString = "good bye"


  val aBoolean: Boolean = false
  val aCharacter: Char = 'c'
  val aInt: Int = x
  val aShort: Short = 400

  // Put L at the end to tell that this number is Long
  val aLong: Long = 812192729111L
  val aFloat: Float = 3.14f
  val aDouble: Double = 2.0


  // Variable -> mutable
  var aVariable: Int = 4

  aVariable = 5 // side effects
  aVariable += 12
}
