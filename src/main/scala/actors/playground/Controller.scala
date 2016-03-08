package actors.playground

import akka.actor.{Props, Actor}
import akka.pattern.PipeableFuture


class Controller extends Actor {
  implicit val exec = context.dispatcher
  val numOfLinesForAllStories = scala.collection.mutable.MutableList[(String, Int)]()
  var links: Seq[String] = Seq()

  def processLinks(url: String) = {
    WebClient.get(url).map {
      bodyText =>
        WebClient.findLinks(bodyText, url).filter(s => s.endsWith(".txt")).toList
    }
  }


  override def receive: Receive = {
    case url: String => new PipeableFuture(processLinks(url)) pipeTo self

    case links: Seq[String] =>
      this.links = links
      links.foreach {
        link =>
          context.actorOf(Props[Getter]) ! link
      }

    case entry@(title: String, numOfLines: Int) =>
      numOfLinesForAllStories += entry.asInstanceOf[(String, Int)]
      if (numOfLinesForAllStories.size == links.size) {
        context.parent ! numOfLinesForAllStories
        context.stop(self)
      }


  }
}
