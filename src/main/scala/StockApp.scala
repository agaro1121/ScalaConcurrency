import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object StockApp {
  def main(args: Array[String]) {


    val buyGoogle = true
    val buyApple = true
    val buyFord = false
    val buyGE = false
    def getStockPrice = {
      Thread.sleep(3000);
      true
    }
    def isMoneyLeftOver(b: Boolean) = b

    val getFirstStockPrice = Future {
      getStockPrice
    }

    val purchase = getFirstStockPrice map { stockPriceResult =>
      if (isMoneyLeftOver(stockPriceResult)) buyGoogle
      else throw new Exception("Sorry Cannot purchase Google")
    } map { previousResult =>
      if (isMoneyLeftOver(previousResult)) buyApple
      else throw new Exception("Sorry Cannot Purchase Apple !")
    } map { previousResult =>
      if (isMoneyLeftOver(previousResult)) buyFord
      else throw new Exception("Sorry Cannot purchase Ford ")
    } map { previousResult =>
      if (isMoneyLeftOver(previousResult)) buyGE
      else throw new Exception("Sorry Cannot purchase GE")
    }

    purchase onComplete {
      case Success(something) => println(something)
      case Failure(error) => println(error.getMessage)
    }


    scala.io.StdIn.readLine()
  }

}