import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import Operations.playBeep


object MicrowaveCallback1 {

  def main(args: Array[String]) {

    println("Heating up food...")
    val microwave = Future {
      Thread.sleep(4000); "DONE!"
    }


    microwave onSuccess {
      case x: String => playBeep; println(x)
    }

    println("Looks at phone while waiting for food...")
    println("Gets glass of water...")
    println("Psych! Getting a bottle of soda :-) ...")
    println("continues to look at phone while waiting")


    scala.io.StdIn.readLine()
  }


}
