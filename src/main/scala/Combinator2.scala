import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}


object Combinator2 {

  def main(args: Array[String]) {

    val codes = Future{ Thread.sleep(2000); "Cheats for Mortal Kombat Received!\nUp, Up, Down, Down, Left, Right, A, B, A\nEveryone wants kool stuff :-)"}

      codes onComplete {
        case Success(something) => println(something)
        case Failure(error) => println("Error ->" + error.getMessage)
      }

    scala.io.StdIn.readLine()
  }



}
