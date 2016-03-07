package actors.behavior

import akka.actor.Actor

class BiPolarActor extends Actor {

  def hulk: Receive = {
    case "get angry" => sender ! "YOU MAKE HULK MORE MAD !!!"
    case "calm down" =>
      println("Hulk is turning Back to Bruce :-)")
      context.become(bruce)
  }

  def bruce: Receive = {
    case "calm down" => sender ! "Bruce is already happy :-)"
    case "get angry" =>
      println("Bruce is going hulk !!!")
      context.become(hulk)
  }

  def receive = {
    case "get angry" =>
      println("Going Hulk !!...")
      context.become(hulk)
    case "calm down" =>
      println("Becoming Bruce :-)")
      context.become(bruce)
  }

}
