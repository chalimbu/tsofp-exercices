package tsofp.chapter3.doneExample.tailRecursionList332

object mapTail extends App{
  def map[A,B](xs: List[A])(f: A=>B): List[B] ={
    xs match {
      case Nil => Nil
      case head :: tail => f(head) :: map(tail)(f)
    }
  }
  
}
