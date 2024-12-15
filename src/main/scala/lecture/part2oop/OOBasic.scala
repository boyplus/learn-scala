package lecture.part2oop

object OOBasic extends App {
  val person = new Person("John", 20)
  println(person.age)
  println(person.x)
  person.greet("Daniel")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val imposeter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge())
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(imposeter))

  val counter = new Counter
  counter.increment.print
  counter.increment.increment.increment.print


  counter.increment(10).print
}

// constructor
// class parameter are not FIELDS
// to convert class parameters to field, add val
class Person(name: String, val age: Int) {
  // body, define implementation of class
  // every val inside class is field
  val x = 2
  println(1 + 3)

  // method
  // this -> refer to the class
  // same method name, different parameter -> overloading method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name")


  // multiple constructor
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")


  /*
    Novel and a Writer

    Writer: firstname, surname, year
      - method: fullname

    Novel: name, year of release, author
    - authorAge
    - iwWrittenBy(author)
    - copy (new year of release) = new instance of Novel
   */

  /*
    Counter class
      - receives an int value
      - method current count
      - method to increment/decrement => new Counter
      - overload inc/dec to receive an amount
   */
}

class Writer(val firstname: String, val surname: String, val year: Int) {
  def fullname(): String = firstname + " " + surname
}

class Novel(val name: String, val year: Int, val author: Writer) {
  def authorAge(): Int = year - author.year
  def isWrittenBy(author: Writer): Boolean = author == this.author // check by reference
  def copy(newYearOfRelease: Int): Novel = Novel(name, newYearOfRelease, author)
}

class Counter(val count: Int = 0) {
  def currentValue(): Int = count

  // no need to add () for parameterless method
  def increment: Counter = {
    println("incrementing")
    new Counter(count + 1) // immutability
  }
  def decrement: Counter = {
    println("decrementing")
    new Counter(count - 1)
  }


  def increment(amount: Int): Counter = {
    if(amount <= 0) this
    else increment.increment(amount-1)
  }

  def decrement(amount: Int): Counter = {
    if(amount <= 0) this
    else decrement.decrement(amount-1)
  }

  def print: Unit = println(this.count)
}