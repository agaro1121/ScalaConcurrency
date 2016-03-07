package actors.ask

import akka.actor.{Props, Actor}
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

import scala.util.{Success, Failure}

class Main extends Actor {

  val receiver = context.actorOf(Props[ActorReceiver],"receiver")
  implicit val timeout = Timeout(5 seconds)

  val resp = receiver ? "Are you getting this message ?"

  resp onComplete{
    case Success(something) => println("Receiving Response: " + something)
    case Failure(error) => println(error)
  }


  override def receive: Receive = {
    case "Done" => context.stop(self)
  }
}
