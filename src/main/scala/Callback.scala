import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


object Callback {

  def main(args: Array[String]) {

    val codes = Future{ Thread.sleep(2000); "Cheats for Mortal Kombat Received!\nUp, Up, Down, Down, Left, Right, A, B, A\nEveryone wants kool stuff :-)"}

      codes onComplete { codeResults =>
        println(codeResults.get)
      }

    scala.io.StdIn.readLine()
  }



}
