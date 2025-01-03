package lecture.part3

import scala.util.Random

object Options extends App {
  val myFirstOption: Option[Int] = Some(1)
  val noOption: Option[Int] = null

  println(myFirstOption)

  def unsafeMethod(): String = null

  //  val result = Some(unsafeMethod()) // WRONG
  val result = Option(unsafeMethod()) // Some or None
  println(result)

  // chained methods
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  // DESIGN unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")

  // user who use the method no need to wrap it with Option
  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  // functions on Options
  println(myFirstOption.isEmpty) // check if Option have a value or not
  println(myFirstOption.get) // UNSAFE - DO NOT USE THIS, program will be crashed when val is null/None

  // map, flatMap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for-comprehensions

  /*
    Exercise
   */

  val config: Map[String, String] = Map(
    // fetched from elsewhere
    "host" -> "176.45.36.1",
    "port" -> "80",
  )

  class Connection {
    def connect = "Connected" // connect to some server
  }
  object Connection {
    def random = new Random(System.nanoTime())
    def apply(host: String, port: String): Option[Connection] =
      if(random.nextBoolean) Some(new Connection)
      else None
  }

  // try to establish a connection, if so - print the connect method
  // FIRST SOLUTION
  val host = config.get("host")
  val port = config.get("port")
  /*
    if (h != null)
      if (p != null)
        return Connection.apply(h, p)
   */
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))

  /*
    if(c != null)
      return c.connect
    return null
   */
  val connectionStatus = connection.map(c => c.connect)

  // if (connectionStatus == null) println(None) else print (Some(connectionStatus.get))
  println(connectionStatus)

  /*
    if (status != null)
      println(status)
   */
  connectionStatus.foreach(println)


  // chained calls
  config.get("host")
    .flatMap(host => config.get("port")
    .flatMap(port => Connection(host, port))
    .map(connection => connection.connect))
    .foreach(println)

  // for-comprehensions
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  forConnectionStatus.foreach(println)

  /*
    Takeaways
    1. Use Options to stay away from Boogeyman
      - avoid runtime crashes due to NPEs
      - avoid an endless amount of null-related assertions
    2. A functional way of dealing with absence
      - map, flatMap, filter
      - orElse
      - others: fold, collect, toList

    *If you design a method to return a (some type) but may return null,
    return an Option[that type] instead.
   */
}
