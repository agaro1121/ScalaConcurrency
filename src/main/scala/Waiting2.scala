import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

object Waiting2 {
  def main(args: Array[String]) {
    val randomStuff = Future{
      println("Doing random stuff...")
      Thread.sleep(7000)
      "DONE DOING RANDOM STUFF!"
    }

    val result = Await.result(randomStuff,60 seconds)

    println(result)
  }
}
