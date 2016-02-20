import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Operations {

  def dbOp = time{
    println("Initializing Database...")
    Thread.sleep(1000)
    println("Getting Database Connection...")
    Thread.sleep(2000)
    println("We have a connection people !!!")
    println("Downloading latest....stuff ?")
    Thread.sleep(5000)
    println("Download Complete ! ")
    println()
  }

  def netOp = time{
    println("Calling the web for something...")
    Thread.sleep(1000)
    println("Logging random smart looking stuff...")
    Thread.sleep(2000)
    println("like opening a socket....")
    Thread.sleep(1000)
    println("establishing a connection...")
    Thread.sleep(3000)
    println("simply to download my latest stocks :-)")
    Thread.sleep(2000)
    println("Yup...")
    Thread.sleep(1000)
    println("It's really doing it...")
    println("LOL HAHA you're still waiting...")
    Thread.sleep(3000)
    println("OK I'm done !")
    println()
  }

  def time[A](f: => A) = {
    val start = System.currentTimeMillis
    val ret = f
    getTimeSince(start)/1000
  }

  def getTimeSince(start: Long): Long = System.currentTimeMillis - start


}
