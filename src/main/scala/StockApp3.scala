import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Random, Success}

object StockApp3 {
  def main(args: Array[String]) {

    val myMoney = Future {
      Thread.sleep(700); 389 + Random.nextInt(2)
    }

    var totalPrice = 0

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

    val listOfPriceJobs = List(getGooglePrice,getApplePrice,getFordPrice,getGePrice)
    val listofPriceJobResults = Future.sequence(listOfPriceJobs)

    val isAffordable = for{
                           funds <- myMoney
                           allPrices <- listofPriceJobResults
                         } yield (allPrices.sum <= funds)

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