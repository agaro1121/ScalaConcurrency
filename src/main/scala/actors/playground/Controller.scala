package actors.playground

import akka.actor.{Props, Actor}

class Controller extends Actor {


  override def receive: Receive = {
    case url: String => println(url)
      /*val html = WebClient get url
      html.map {
        bodyText =>
          WebClient.findLinks(bodyText, url).filter(s => s.endsWith(".txt"))
      }.foreach {
        list =>
          list.foreach { link =>
            val getter = context.actorOf(Props[Getter])
            getter ! link
          }
      }*/

  }

}
