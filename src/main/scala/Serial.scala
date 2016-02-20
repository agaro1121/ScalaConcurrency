import Operations._

object Serial {
  def main(args: Array[String]) {
    val start = System.currentTimeMillis
    val a = dbOp
    val b = netOp
    println(s"Total taken: ${a + b} seconds")
    scala.io.StdIn.readLine()
  }




}
