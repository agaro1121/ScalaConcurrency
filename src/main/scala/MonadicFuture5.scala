import Operations.errorResult

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object MonadicFuture5 {
  def main(args: Array[String]) {

    val exampleFuture = Future {
      Thread.sleep(1000)
      6
    }

    val badFuture = Future {
      Thread.sleep(1000)
      errorResult
    }


    badFuture recover {
      case error => println("Recovering with Default value 6")
    }

    scala.io.StdIn.readLine()
  }
}
