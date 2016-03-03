package actors.counter

import akka.actor.{Props, Actor}
import akka.actor.Actor.Receive

/**
  * Created by hierro on 3/2/16.
  */
class CounterMain extends Actor{
  val counter = context.actorOf(Props[Counter],"counter")

  counter ! "incr"
  counter ! "incr"
  counter ! "incr"
  counter ! "get"


  override def receive: Receive = {
    case count: Int =>
      println(s"count was $count")
      context.stop(self)
  }
}
