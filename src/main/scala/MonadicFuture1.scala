import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import Operations.errorResult

object MonadicFuture1 {
  def main(args: Array[String]) {

    def timesTwoAddOne(x: Int): Int = x * 2 + 1
    def toThirdPower(x: Int) = x * x * x

    val exampleFuture = Future{
      Thread.sleep(1000)
      6
    }

    val badFuture = Future {
      Thread.sleep(1000)
      errorResult
    }

    exampleFuture filter(x => x < 7)                               onSuccess{case result:Int => println(s"filtered by x < 7 Result = $result\n")}
    exampleFuture filter(x => x > 7)                               onFailure{case throwable => println(s"filtered by x > 7 Result = "+throwable)}
    exampleFuture map(x => x + 2)                                  onComplete{result => println(s"Mapped Result = $result\n")}
    exampleFuture map(timesTwoAddOne)                              onComplete(result => println(s"timesTwoAddOne Result = $result\n"))
    exampleFuture map(toThirdPower)                                onComplete(x => println(s"toThirdPower Result = $x\n"))
    exampleFuture zip(exampleFuture map(timesTwoAddOne))           onSuccess{case result:(Int,Int) => println(s"Zip Result = $result\n")}
    exampleFuture collect{ case x if(x < 7) => timesTwoAddOne(x) } onComplete(result => println(s"Collect by x < 7 Reseult = $result\n"))
    exampleFuture collect{ case x if(x > 7) => timesTwoAddOne(x) } onComplete(result => println(s"Collect by x > 7 Reseult = $result\n"))

    val f1 = badFuture fallbackTo{println("Falling Back to Example Future\n") ; exampleFuture}
      f1.onComplete{x => println("Successfully fell back to example Future with value = " + x)}

    badFuture fallbackTo{println("Falling Back to Example Future") ; exampleFuture}
        .andThen{case x => println(s"Doing this in order for better visibility. exampleFuture Value = $x\n")}

    badFuture recover{case error => println("Recovering with Default value 6")}

    val f2 = badFuture recoverWith{case t:ArithmeticException => println("Recovering With Example Future\n") ;exampleFuture}
      f2.onComplete{x => println("Successfully recoveredWith example Future with value = " + x)}

    scala.io.StdIn.readLine()
  }
}
