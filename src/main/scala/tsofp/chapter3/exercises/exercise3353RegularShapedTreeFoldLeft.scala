package tsofp.chapter3.exercises

import scala.annotation.tailrec

object exercise3353RegularShapedTreeFoldLeft extends App{
  sealed trait RTree[A]
  final case class Leaf[A](x: A) extends RTree[A]
  final case class Branch[A](xs: RTree[(A,A)]) extends RTree[A]

  @tailrec
  def foldLeft[A,R](t: RTree[A])(init: R)(f: (R,A)=>R): R={
    t match {
      case Leaf(x) => f(init,x)
      case Branch(xs) =>
        xs match{
          case Branch()=>
        }
        foldLeft(xs)(init){case (x,y)=>(f(init,x),f(init,y)))}

    }
  }

  println(foldLeft(Branch(Branch(Leaf(((1,2),(3,4))))))(0)(_+ _))
  //10
  //println(foldLeft(Branch(Branch(Leaf((("a","b"),("c","d"))))))("")(_ + _))
}
