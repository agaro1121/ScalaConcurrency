import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object MonadicFuture1 {
  def main(args: Array[String]) {

    val exampleFuture = Future{
      Thread.sleep(1000)
      6
    }

    exampleFuture
      .filter(x => x < 7)
      .onSuccess{
        case result:Int => println(s"filtered by x < 7 Result = $result\n")
      }

    exampleFuture
      .filter(x => x > 7)
      .onFailure{
        case throwable => println(s"filtered by x > 7 Result = "+throwable)
      }



    scala.io.StdIn.readLine()
  }
}
