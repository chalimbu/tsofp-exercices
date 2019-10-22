package tsofp.chapter2.doneExamples

import scala.annotation.tailrec

object tailRecursion extends App{

  @tailrec
  def fromDigits(s: Seq[Int],res: Int=0):Int={
    if(s==Seq()) res
    else fromDigits(s.tail,10*res+s.head)
  }

  println(fromDigits(Seq(1,2,3,4)))
}
