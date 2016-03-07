package actors.ask

import akka.actor.{Props, Actor}
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

import akka.pattern.PipeableFuture


class Main extends Actor {

  val receiver = context.actorOf(Props[ActorReceiver],"receiver")
  val tester = context.actorOf(Props[ActorReceiver],"tester")
  implicit val timeout = Timeout(5 seconds)


  val resp = new PipeableFuture(receiver ? "Are you getting this message ?") pipeTo self

  override def receive: Receive = {
    case something:String => println(s"Receiving Response: " + something)
  }
}
