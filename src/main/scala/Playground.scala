import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by hierro on 3/2/16.
  */
object Playground {

  def main(args: Array[String]) {
    val aa = Future{scala.io.Source.fromURL("http://textfiles.com/stories/wlgirl.txt")  .getLines().toSeq}
    val bb = Future{scala.io.Source.fromURL("http://textfiles.com/stories/wolf7kid.txt").getLines().toSeq}
    val cc = Future{scala.io.Source.fromURL("http://textfiles.com/stories/wolfcran.txt").getLines().toSeq}
    val dd = Future{scala.io.Source.fromURL("http://textfiles.com/stories/wolflamb.txt").getLines().toSeq}

    val result = for{
      a <- aa
      b <- bb
      c <- cc
      d <- dd
    }yield Seq(a.head.trim, b.head.trim, c.head.trim, d.head.trim) zip Seq(a.size, b.size, c.size, d.size)


    result onSuccess{case res:Seq[(String,Int)] => println("\n"+res.mkString("\n"))}


    scala.io.StdIn.readLine()
  }


}
