import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}


object Callback1 {

  def main(args: Array[String]) {

    val codes = Future{
      Thread.sleep(2000)
      "Cheats for Mortal Kombat Received!\n" +
        "Up, Up, Down, Down, Left, Right, A, B, A\n" +
        "Everyone wants kool stuff :-)"
    }

    codes onSuccess{
      case something => println(something)
    }

    scala.io.StdIn.readLine()
  }



}
