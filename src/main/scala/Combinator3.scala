import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import Operations.errorResult


object Combinator3 {

  def main(args: Array[String]) {

    val codes = Future{ Thread.sleep(2000); "Cheats for Mortal Kombat Received!\nUp, Up, Down, Down, Left, Right, A, B, A\nEveryone wants kool stuff :-)"}

    codes onSuccess{
      case something => println(something)
    }

    codes onFailure {
      case error => println("There was an error")
    }

    scala.io.StdIn.readLine()
  }



}
