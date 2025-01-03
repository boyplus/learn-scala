package lecture.part1basic

object DefaultArgs extends App {
  // Default argument
  def trFact(n: Int, acc: Int = 1): Int = {
    if(n <= 1) acc
    else trFact(n-1, n * acc)
  }

  val fact10 = trFact(10)
  println(fact10)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")

  /*
    1. pass in every leading argument
    2. name the arguments
   */
  savePicture()
  savePicture(width = 800, height = 600)
  savePicture(height = 600, width = 800, format = "bmp")
}
