package tsofp.chapter3.trees

import tsofp.chapter3.exercises.exercise3323NelToList.{Last, More, NEL}

import scala.annotation.tailrec

object roseTree extends App{
  sealed trait TreeN[A]
  final case class Leaf[A](a: A) extends TreeN[A]
  final case class Branch[A](ts: NEL[TreeN[A]]) extends TreeN[A]

            //Int,
  def foldLeft[A,R](t: TreeN[A])(init: R)(f: (R,A)=> R): R = {
    t match {
      case Leaf(a) => f(init,a)
      case Branch(nelt) =>
        nelt match {
          case Last(head) => foldLeft(head)(init)(f)
          case More(head, tail) =>{
            val previousResul: R =foldLeft(head)(init)(f)
            foldLeft(Branch(tail))(previousResul)(f)
          }
        }

    }
  }

  println(foldLeft(Branch[Int](More[TreeN[Int]](Leaf(1),More(Leaf(2),Last(Leaf(3))))))(0)(_+_))
}
