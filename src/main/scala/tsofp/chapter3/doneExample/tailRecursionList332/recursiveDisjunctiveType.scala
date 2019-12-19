package tsofp.chapter3.doneExample.tailRecursionList332

object recursiveDisjunctiveType extends App{
  sealed trait NInt

  final case class N1(x: Int) extends NInt
  final case class N2(x: NInt) extends NInt

  println(N2(N2(N1(1))))

  sealed trait ListI[A]
  final case class List0[A]() extends ListI[A]
  final case class ListN[A](prev: ListI[A],x: A) extends ListI[A]
  println(s"empy list ${List0}")
  println(s"one element ${ListN[Int](List0[Int](),3)}")
  println(s"one element ${ListN(ListN(List0(),3),4)}")

}

