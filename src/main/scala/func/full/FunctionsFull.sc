def plus(x: Int, y: Int) = x + y
def sub(x: Int, y: Int) = x - y
def multiply(x: Int, y: Int) = x * y
def divide(x: Int, y: Int) = {
  require(y != 0, "Cannot Divide by Zero !")
  x / y
}

divide(1,0)
