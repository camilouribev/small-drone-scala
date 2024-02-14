import scala.io.StdIn

@main
def main(): Unit = {
  val drone: Drone = Drone(0, 0, 0)
  handleInput(drone)

}

def handleInput(drone: Drone): Unit = {
  println(s"Welcome, the current drone coordinates (x, y , z) are (${drone.x}, ${drone.y} , ${drone.z}). Please move up, down , forwards, backwards, right or left: \n")
  val input: String = StdIn.readLine()

  input.trim().toLowerCase() match
    case "up" => moveUp(drone)
    case "down" => moveDown(drone)
    case "right" => moveRight(drone)
    case "left" => moveLeft(drone)
    case "forwards" => moveForwards(drone)
    case "backwards" => moveBackwards(drone)
    case _ =>
      println("Invalid command, please try again")
      handleInput(drone)
}


def moveUp(drone: Drone): Unit = {
  if (drone.z >= 100) {
    println("Cannot go any higher. Maximum Z coordinate")
    handleInput(drone)
  } else {
    handleInput(Drone(drone.x, drone.y, drone.z + 5))
  }
}

def moveDown(drone: Drone): Unit = {
  if (drone.z <= -50) {
    println("Cannot go any lower. Minimum Z coordinate")
    handleInput(drone)
  } else {
    handleInput(Drone(drone.x, drone.y, drone.z - 5))
  }
}

def moveRight(drone: Drone): Unit = handleInput(Drone(drone.x + 5, drone.y, drone.z))

def moveLeft(drone: Drone): Unit = handleInput(Drone(drone.x - 5, drone.y, drone.z))

def moveForwards(drone: Drone): Unit = handleInput(Drone(drone.x, drone.y + 5, drone.z))

def moveBackwards(drone: Drone): Unit = handleInput(Drone(drone.x, drone.y - 5, drone.z))

