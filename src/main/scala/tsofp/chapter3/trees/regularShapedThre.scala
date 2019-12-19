package tsofp.chapter3.trees

object regularShapedThre extends App{
  sealed trait RTree[A]
  final case class Leaf[A](x: A) extends RTree[A]
  final case class Branch1[A](xs: RTree[(A,A)]) extends RTree[A]
  //              _________
  //      ________
  //              _________
  //  ____
  //               ________
  //       ________
  //               ________

}
