import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}
import scala.util.Random

object Promise3 {
  def main(args: Array[String]) {

    val horse1 = Future {
      val time = getTime
      println(s"Horse1 takes $time long to run")
      Thread.sleep(time)
      "HORSE 1 WINS !!!"
    }
    val horse2 = Future {
      val time = getTime
      println(s"Horse2 takes $time long to run")
      Thread.sleep(time)
      "HORSE 2 WINS !!!"
    }
    val horse3 = Future {
      val time = getTime
      println(s"Horse3 takes $time long to run")
      Thread.sleep(time)
      "HORSE 3 WINS !!!"
    }

    val winner = race(horse1, horse2, horse3)
    winner onSuccess { case result => println(result) }


    scala.io.StdIn.readLine()
  }

  def race(h1: Future[String], h2: Future[String], h3: Future[String]) = {
    val winner = Promise[String]

    h1 onSuccess { case x => winner trySuccess (x) }
    h2 onSuccess { case x => winner trySuccess (x) }
    h3 onSuccess { case x => winner trySuccess (x) }

    winner.future
  }


  def getTime = {
    val time = 1000 + (100 * Random.nextInt(9))
    time
  }


}