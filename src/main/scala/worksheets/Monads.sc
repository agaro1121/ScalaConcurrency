def timesTwoAddOne(x: Int): Int = x * 2 + 1
def toThirdPower(x: Int) = x * x * x

val list = List(1,2,3,4,5,6,7,8,9,10)

val l = list.map(numberInside => numberInside * 2)
val l1 = list.filter(x => x < 6)
val l2 = list filter(x => x < 6)

val l3 = list
          .filter(numberInside => numberInside < 6)
          .map(numberInside => numberInside * 2)


val l4 = list filter(x => x < 6) map(numberInside => timesTwoAddOne(numberInside))
/** Or just simply...*/
list filter(x => x < 6) map(timesTwoAddOne)

val l5 = l2 map(toThirdPower)

val l6 = (list.filter(x => x < 6)) zip l3

val l7 = l1 zip l3

val l8 = l1 zip l4

val l9 = list collect { case x if(x < 6) => timesTwoAddOne(x) } //does l3 in one line

val `l4 equal to l9` = l4 == l9
