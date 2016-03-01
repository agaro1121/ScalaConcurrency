import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Promise

object Promise2 {
  def main(args: Array[String]) {

  val promise = Promise[Int]
  val futureFromPromise = promise.future

  promise failure(new ArithmeticException("You suck at math"))
  futureFromPromise.onComplete(println(_))


    scala.io.StdIn.readLine()
  }
}
