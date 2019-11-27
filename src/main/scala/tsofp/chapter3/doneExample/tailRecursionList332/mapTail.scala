package tsofp.chapter3.doneExample.tailRecursionList332

import scala.annotation.tailrec

object mapTail extends App{
  def map[A,B](xs: List[A])(f: A=>B): List[B] ={
    xs match {
      case Nil => Nil
      case head :: tail => f(head) :: map(tail)(f)
    }
  }

  @tailrec
  def foldLeft[A,R](xs: List[A])(init: R)(f: (R,A) => R): R= {
    xs match {
      case Nil =>init
      case head::nexts =>
        val newInit=f(init,head)
        foldLeft(nexts)(newInit)(f)
    }
  }
  println(foldLeft[Int,Int](List(3,4,5,6))(0)((a,b)=>a+b))

}
