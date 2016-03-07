package actors.counter

import akka.actor.Actor

class Counter extends Actor {
  var count = 0
  override def receive: Receive = {
    case "incr" => count += 1
    case "get" => sender ! count
  }
}
