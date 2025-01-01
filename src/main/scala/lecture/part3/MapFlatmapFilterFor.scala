package lecture.part3

object MapFlatmapFilterFor extends App {
  // creating a list from apply method in List companion object
  val list = List(1,2,3)
  println(list)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  // print all combinations between two lists
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  // Output -> List("a1", "a2", "" ,..., "d4")

  // My solution
  val pairing = (a: Char, b: List[Int]) => b.map(x => a+""+x)
  val output = chars.flatMap(c => pairing(c, numbers))
  println(output)

  // Author solution
  val combinations = numbers.flatMap(n => chars.map(c => c + "" + n))
  println(combinations)
}
