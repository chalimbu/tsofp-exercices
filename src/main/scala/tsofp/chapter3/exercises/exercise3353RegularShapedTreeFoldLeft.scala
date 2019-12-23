package tsofp.chapter3.exercises

import scala.annotation.tailrec

object exercise3353RegularShapedTreeFoldLeft extends App{
  sealed trait RTree[A]
  final case class Leaf[A](x: A) extends RTree[A]
  final case class Branch[A](xs: RTree[(A,A)]) extends RTree[A]

  //solution from
  //https://stackoverflow.com/questions/59430145/regular-shaped-tree-fold-left-scala-implementation
  @tailrec
  def foldLeft[A,R](t: RTree[A])(init: R)(f: (R,A)=>R): R= {
    t match {
      case Leaf(x) => f(init, x)
      case Branch(xs) =>
        foldLeft(xs)(init) { case (interInit, (leftT, rightT)) => {
          f(f(interInit, leftT), rightT)
        }
        }
    }
  }

  println(foldLeft(Branch(Branch(Leaf(((1,2),(3,4))))))(0)(_+ _))
  //10
  println(foldLeft(Branch(Branch(Leaf((("a","b"),("c","d"))))))("")(_ + _))
}
