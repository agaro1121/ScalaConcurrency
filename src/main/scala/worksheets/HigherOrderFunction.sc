def plus(x: Double, y: Double) = x + y

def calculate(x:Double, y:Double)(f:(Double,Double) => Double) = {
  f(x,y)
}

calculate(2,3)(plus)


// create your own function below to call with your
// new higher order function
def notGood(x: Double, y: Double) = 7.0
calculate(3,2)(notGood)
