package tsofp.chapter3.doneExample.tailRecursionList332

object example3322reverseNEL extends App{
  sealed trait NEL[A]
  final case class Last[A](head: A) extends NEL[A]
  final case class More[A](head: A,tail: NEL[A]) extends NEL[A]


}
