package actors.playground

import java.util.concurrent.Executor

import com.ning.http.client.AsyncHttpClient
import org.jsoup.Jsoup

import scala.concurrent.{Future, Promise}
import scala.collection.JavaConverters._
import akka.pattern.PipeableFuture

class WebClient {

  val client = new AsyncHttpClient

  def get(url: String)(implicit exec: Executor): Future[String] = {
    val f = client.prepareGet(url).execute()
    val p = Promise[String]()
    f.addListener(new Runnable {
      override def run(): Unit = {
        val response = f.get
        if (response.getStatusCode < 400)
          p success response.getResponseBody
        else p failure new Throwable(response.getStatusCode.toString)
      }
    }, exec)
    p.future
  }

  def findLinks(body: String, url: String): Iterator[String] = {
    val document = Jsoup.parse(body,url)
    val links = document.select("A[HREF]")
    for {
      link <- links.iterator().asScala
    } yield link.absUrl("href")
  }

  def shutdown(): Unit = {
    if(!client.isClosed) client.close()
  }

}

object WebClient extends WebClient
