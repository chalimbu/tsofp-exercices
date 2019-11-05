package tsofp.chapter2.doneExamples

object stream extends App{
  val list=LazyList.iterate(2){x=>x+10}.takeWhile(_<100).toList
  println(list)

  def partialSums(xs: Seq[Int]):Seq[Int] = xs.scanLeft(0){(x,y)=>x+y}
  println()
}
