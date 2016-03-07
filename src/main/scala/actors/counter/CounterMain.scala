package actors.counter

import akka.actor.{Props, Actor}

class CounterMain extends Actor{
  val counterActor = context.actorOf(Props[Counter],"counter")
  //counterActor is the ActorRef. A reference to the underlying actor

  counterActor ! "incr"
  counterActor ! "incr"
  counterActor ! "incr"
  counterActor ! "get"


  override def receive: Receive = {
    case count: Int =>
      println(s"count was $count")
      context.stop(self)
  }
}
