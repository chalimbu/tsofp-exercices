package tsofp.chapter3.exercises

import tsofp.chapter3.exercises.exercise3323NelToList.{Last, More, NEL}

import scala.annotation.tailrec

object exampleFoldLeftNEl extends App{
  @tailrec
  def foldLeft[A,R](n: NEL[A])(init: R)(f: (R,A)=> R):R =
    n match {
      case Last(head) =>  f(init,head)
      case More(head, tail) => foldLeft(tail)(f(init,head))(f)
    }

  println(foldLeft(More(1,More(2,Last(3))))(0)(_+_))
}
