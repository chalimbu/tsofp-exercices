package tsofp.chapter2.doneExamples

object ExtractDigitsFromSequence extends App{
  val a=Iterator.iterate((123,0)) {
    case (m,_)=> (m/10,m%10)
  }.takeWhile{case (m,d) => m>0 || d>0}.drop(1).toList
      .map(_._2)
  println(a)

}
