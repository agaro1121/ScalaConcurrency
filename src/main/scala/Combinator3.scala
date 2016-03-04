import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import Operations.errorResult

import scala.util.{Failure, Success}


object Combinator3 {

  def main(args: Array[String]) {

    val codes = Future{
      Thread.sleep(2000)
      "Cheats for Mortal Kombat Received!\n" +
        "Up, Up, Down, Down, Left, Right, A, B, A\n" +
        "Everyone wants kool stuff :-)"
      5/0
    }

    codes onComplete {
      case Success(something) => println(something)
      case Failure(error) => println("There was an error")
    }

    scala.io.StdIn.readLine()
  }



}
