import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


@volatile var totalA = 0
val text = Future {
  "na" * 16 + "BATMAN!!!"
}

text onSuccess {
  case txt => totalA += txt.count(_ == 'a')
}
text onSuccess {
  case txt => totalA += txt.count(_ == 'A')
}

text onSuccess {
  case txt => Thread.sleep(800) ; println(s"\n$txt\nTotal = $totalA")
}

