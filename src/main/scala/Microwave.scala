import scala.concurrent.{Future, Await}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global


object Microwave {

  def main(args: Array[String]) {

    val microwave = Future{ println("Heating up food..."); Thread.sleep(2000); "DONE!"}

    val r = Await.result(microwave,60 seconds)
    println(r)

  }



}
