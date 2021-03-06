import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import Operations._

object MicrowaveCallback1 {

  def main(args: Array[String]) {

    val microwave = Future {
      println("Heating up stuff...")
      Thread.sleep(4000)
      errorResult
      "DONE!"
    }

    microwave onSuccess {
      case result =>
        playBeep
        println(result)
    }

    microwave onFailure {
      case error =>
        playExplosion
        println("Oh no my chocolate exploded :-( ")
    }

    println("Looks at phone while waiting for food...")
    println("Getting glass of water...")
    println("Psych! Getting a bottle of soda :-)")
    println("continues to look at phone while waiting...")

    scala.io.StdIn.readLine()
  }


}
