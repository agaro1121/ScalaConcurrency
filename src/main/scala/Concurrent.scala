import scala.concurrent.Future
import Operations._
import scala.concurrent.ExecutionContext.Implicits.global

object Concurrent {
  def main(args: Array[String]) {
    val a = Future(dbOp)
    val b = Future(netOp)

    val r = for{
      x <- a
      y <- b
    } yield Seq(x,y).max

    r.onComplete(_ map(y => println(s"Total time: $y seconds")))

    scala.io.StdIn.readLine()
  }
}
