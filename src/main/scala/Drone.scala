case class Drone( x: Int, y: Int, z: Int){
    def apply(x: Int, y: Int, z: Int): Drone = new Drone(x, y, z)
}