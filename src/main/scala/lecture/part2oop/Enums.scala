package lecture.part2oop

object Enums extends App {

  // data type, can contains fields/method
  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    // add fields/methods
    def openDocument(): Unit = {
      if(this == READ) println("opening document...")
      else println("reading not allowed")
    }
  }

  // constructor args
  enum PermissionsWithBits(bits: Int){
    case READ extends PermissionsWithBits(4) // 100
    case WRITE extends PermissionsWithBits(2) // 010
    case EXECUTE extends PermissionsWithBits(1) // 001
    case NONE extends PermissionsWithBits(0) // 000
  }

  object PermissionsWithBits {
    def fromBits(bits: Int): PermissionsWithBits = PermissionsWithBits.NONE
  }

  val somePermissions: Permissions = Permissions.READ
  somePermissions.openDocument()

  // standard API
  val somePermissionsOrdinal = somePermissions.ordinal
  val allPermissions = PermissionsWithBits.values // array of all possible value of the enum
  val readPermission: Permissions = Permissions.valueOf("READ") // Permissions.READ


  println(somePermissionsOrdinal)
  println(allPermissions)
  println(readPermission)
}
