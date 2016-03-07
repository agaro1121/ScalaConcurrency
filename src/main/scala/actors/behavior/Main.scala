package actors.behavior

import akka.actor.{Props, Actor}

class Main extends Actor {
  val bruceBanner = context.actorOf(Props[BiPolarActor], "bruce")

    bruceBanner ! "get angry"
    bruceBanner ! "calm down"
    bruceBanner ! "get angry"
    bruceBanner ! "calm down"

    bruceBanner ! "get angry"
    bruceBanner ! "get angry"
    bruceBanner ! "get angry"

  override def receive: Receive = {
    case resp:String => println(resp)
  }
}
