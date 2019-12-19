package tsofp.chapter3.trees

object binaryTree extends App{
  sealed trait Tree2[A]
  final case class Leaf[A](a: A)  extends Tree2[A]
  final case class Branch[A](x: Tree2[A], y: Tree2[A]) extends Tree2[A]

  def foldLeft[A,R](t: Tree2[A])(init: R)(f: (R,A)=>R): R =
    t match {
      case Leaf(a) => f(init,a)
      case Branch(left, right) =>
        val r1= foldLeft(left)(init)(f)
        foldLeft(right)(r1)(f)
    }


  println(foldLeft(Branch(Leaf(3),Branch(Leaf(1),Leaf(4))))(3)(_+_))
  // ----º-3
  //     º--º1
  //        º4
  println(foldLeft(Branch(Leaf("marta"),Branch(Leaf("jorge"),Leaf("miguel"))))("")(_+" "+_))
}
