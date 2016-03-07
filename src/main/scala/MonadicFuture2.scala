
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object MonadicFuture2 {
  def main(args: Array[String]) {

    def timesTwoAddOne(x: Int): Int = x * 2 + 1
    def toThirdPower(x: Int) = x * x * x

    val exampleFuture = Future{
      Thread.sleep(1000)
      6
    }

    exampleFuture
      .map(x => x + 2)
      .onComplete{
        result => println(s"Mapped Result = $result\n")
      }

    exampleFuture
      .map(timesTwoAddOne)
      .onComplete(result => println(s"timesTwoAddOne Result = $result\n"))

    exampleFuture
      .map(toThirdPower)
      .onComplete(result => println(s"toThirdPower Result = $result\n"))

    scala.io.StdIn.readLine()
  }
}
