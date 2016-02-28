def plus(x: Double, y: Double): Double = x + y

def sub(x: Double, y: Double) = ???

//insert multiply function below

def divide(x: Double, y: Double) = {
  require(y != 0, "Cannot Divide by Zero !")
  x / y
}
