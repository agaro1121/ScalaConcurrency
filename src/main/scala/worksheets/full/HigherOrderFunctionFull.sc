def plus(x: Double, y: Double) = x + y
def sub(x: Double, y: Double) = x - y
def multiply(x: Double, y: Double) = x * y
def divide(x: Double, y: Double) = {
  require(y != 0, "Cannot Divide by Zero !")
  x / y
}

def calculate(x:Double, y:Double)(f:(Double,Double) => Double) = {
  f(x,y)
}


calculate(2,3)(plus)
calculate(2,3)(sub)
calculate(2,3)(multiply)
calculate(2,3)(divide)

def notGood(x: Double, y: Double) = 7.0
calculate(3,2)(notGood)
