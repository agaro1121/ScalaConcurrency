import Operations.playSound

import scala.concurrent.{Future, Await}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success, Try}


/**\
  * Created by Hierro on 2/26/16.
  */
object Microwave {

  def main(args: Array[String]) {
//    playSound

    val microwave = Future{ println("Heating up food..."); Thread.sleep(2000); "DONE!"; 5/0}

//    Await.ready(microwave,60 seconds)

//      microwave onSuccess{
//        case x:String => playSound ; println(x)
//      }

//      microwave onComplete{
//        case Success(x) => playSound
//        case Failure(t) => print(t.getMessage)
//      }

      microwave onFailure{
        case t => Console.println(t.getMessage)
      }

    scala.io.StdIn.readLine()
  }



}
