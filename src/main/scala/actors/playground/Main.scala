package actors.playground

import akka.actor.{Props, Actor}

class Main extends Actor {
  val url = "http://textfiles.com/stories/"

  val controller = context.actorOf(Props[Controller], "controller")

  controller ! url

  override def receive: Receive = {
    case numOfLinesForAllStories: Seq[(String, Int)] =>
      println("Task Complete !")
      println(s"size = ${numOfLinesForAllStories.size}")
      println("Here is your list:")
      println(s"${numOfLinesForAllStories.mkString("\n")}")
      context.stop(self)
  }

}
