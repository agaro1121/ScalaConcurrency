import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}
import Operations.playBeep
import Operations.playExplosion

object MicrowaveCallback3 {

  def main(args: Array[String]) {

    val microwave = Future{
      println("Heating up food...")
      Thread.sleep(2000)
      "DONE!"
    }

      microwave onComplete{
        case Success(result) => playBeep ; print(result)
        case Failure(error) => playExplosion ; print(error.getMessage)
      }

    println("Looks at phone while waiting for food...")
    println("Gets glass of water...")
    println("Psych! Getting a bottle of soda :-) ...")
    println("continues to look at phone while waiting")

    scala.io.StdIn.readLine()
  }



}
