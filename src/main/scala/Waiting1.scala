import scala.concurrent.{Future, Await}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object Waiting1 {
  def main(args: Array[String]) {
    val randomStuff = Future{ println("Doing random stuff..."); Thread.sleep(3000); "DONE DOING RANDOM STUFF!"}

    val x = Await.ready(randomStuff,60 seconds)

    println(x.value)
  }
}
