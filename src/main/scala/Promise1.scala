import scala.concurrent.Promise
import scala.concurrent.ExecutionContext.Implicits.global

object Promise1 {
  def main(args: Array[String]) {

  val promise = Promise[Int]
  val futureFromPromise = promise.future

  promise success 1
  futureFromPromise.onComplete(println(_))


    scala.io.StdIn.readLine()
  }
}
