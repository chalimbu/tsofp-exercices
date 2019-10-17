package tsofp.chapter2.doneExamples

object digitsToInt extends App{
  def sum(s: Seq[Int]): Int = if(s==Seq()) 0 else{
    val x= s.head
    val xs= s.tail
    sum(xs)+x
  }
  println(sum(Seq(2,23,4)))

  def fromDigits(digist: Seq[Int],res: Double=0): Double={
    if(digist.isEmpty) res.toDouble
    else fromDigits(digist.tail,res+digist.head*Math.pow(10,(digist.length-1)))
  }
  println(fromDigits(Seq(1,3,2,4,5)))
}
