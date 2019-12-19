package tsofp.chapter3.exercises

import scala.annotation.tailrec

object exercise3352depthOfRegularShapped extends App{
  sealed trait RTree[A]
  final case class Leaf[A](x: A) extends RTree[A]
  final case class Branch[A](xs: RTree[(A,A)]) extends RTree[A]


  def depth[A](t:RTree[A]): Int = {
    @tailrec
    def depthHelpher[A](t:RTree[A],acumulator:Int=0): Int={
      t match {
        case Leaf(x) => acumulator
        case Branch(xs) =>depthHelpher(xs,acumulator+1)
      }
    }
    depthHelpher(t)
  }

  println(depth(Branch(Branch(Leaf((("a","b"),("c","d")))))))
}
