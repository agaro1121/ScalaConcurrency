package actors.playground

import java.nio.charset.StandardCharsets

import akka.actor.Actor

class Getter extends Actor {

  def process(url: String):(String,Int) = {
  val storyLines =  scala.io.Source.fromURL(url,StandardCharsets.ISO_8859_1.toString)
      .getLines()
      .toSeq

    (storyLines.head.trim,storyLines.size)
  }

  override def receive: Receive = {
    case url:String =>
      val result = process(url)
      sender ! result
      context.stop(self)

  }
}