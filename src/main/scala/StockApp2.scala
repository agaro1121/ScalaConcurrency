import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Random, Failure, Success}

object StockApp2 {
  def main(args: Array[String]) {

    val myMoney = Future {
      Thread.sleep(700); 389 + Random.nextInt(2)
    }

    val getGooglePrice = Future {
      Thread.sleep(1000); 100
    }
    val getApplePrice = Future {
      Thread.sleep(2000); 200
    }
    val getFordPrice = Future {
      Thread.sleep(2500); 30
    }
    val getGePrice = Future {
      Thread.sleep(3500); 60
    }

    val isAffordable = for {
      googlePrice <- getGooglePrice
      applePrice <- getApplePrice
      fordPrice <- getFordPrice
      gePrice <- getGePrice
      funds <- myMoney
    } yield if (List(googlePrice, applePrice, fordPrice, gePrice).sum <= funds) true else false

    isAffordable onComplete {
      case Success(result) => {
        if (result) println("LETS BUY SOME STOCKS WHOOOOOOOOOOO !!!!!!!!!!!!")
        else println("Gosh darnit I need more money....Gimme some money :-)")
      }
      case Failure(error) => println(error.getMessage)
    }


    scala.io.StdIn.readLine()
  }

}