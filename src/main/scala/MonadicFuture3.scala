import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object MonadicFuture3 {
  def main(args: Array[String]) {

    def timesTwoAddOne(x: Int): Int = x * 2 + 1
    def toThirdPower(x: Int) = x * x * x

    val exampleFuture = Future{
      Thread.sleep(1000)
      6
    }

    exampleFuture
      .filter(x => x < 7)
      .map(x => x + 2)
      .map(toThirdPower)
      .onSuccess{case result:Int => println(s"filtered by x < 7 Result = $result\n")}

    exampleFuture
      .filter(x => x > 7)
      .map(timesTwoAddOne)
      .onFailure{case throwable => println(s"filtered by x > 7 Result = "+throwable)}


    scala.io.StdIn.readLine()
  }
}
