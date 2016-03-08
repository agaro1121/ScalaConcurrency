import Operations.errorResult

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object MonadicFuture6 {
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
      .recoverWith {
        case t: ArithmeticException => println("Recovering With Example Future\n")
          exampleFuture
      }
      .onComplete {
        x => println("Successfully recoveredWith example Future with value = " + x)
      }

    scala.io.StdIn.readLine()
  }
}
