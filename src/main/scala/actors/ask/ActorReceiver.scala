package actors.ask

import akka.actor.Actor

class ActorReceiver extends Actor {
  override def receive: Receive = {
    case msg: String =>
      println(s"Message received !")
      println(s"Contents: $msg")
      sender ! "I have received your message!"
      context.parent ! "Done"
  }
}
