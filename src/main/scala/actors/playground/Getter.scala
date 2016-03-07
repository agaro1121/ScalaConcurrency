package actors.playground

import akka.actor.Actor

class Getter extends Actor {

  def process(url: String) = {
  val storyLines =  scala.io.Source.fromURL("http://textfiles.com/stories/wlgirl.txt")
      .getLines()
      .toSeq

    (storyLines.head.trim,storyLines.size)
  }

  override def receive: Receive = {
    case url:String =>
      val result = process(url)
      sender ! result
  }
}
