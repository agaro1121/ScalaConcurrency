import Operations.errorResult

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object MonadicFuture4 {
  def main(args: Array[String]) {

    val exampleFuture = Future {
      Thread.sleep(1000)
      6
    }

    val badFuture = Future {
      Thread.sleep(1000)
      errorResult
    }


    badFuture
      .fallbackTo {
        println("Falling Back to Example Future\n")
        exampleFuture
      }
      .onComplete {
        x => println("Successfully fell back to example Future with value = " + x)
      }

    scala.io.StdIn.readLine()
  }
}
