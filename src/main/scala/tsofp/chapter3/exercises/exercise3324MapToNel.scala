package tsofp.chapter3.exercises

object exercise3324MapToNel extends App{
  sealed trait NEL[A]
  final case class Last[A](head: A) extends NEL[A]
  final case class More[A](head: A,tail: NEL[A]) extends NEL[A]

  def toNEL[A](x:A, rest:List[A]):NEL[A] =
    rest match{
      case Nil=>Last(x)
      case y::tail => More(x, toNEL(y, tail))
    }
  def map[A,B](xs: NEL[A])(f: A=>B): NEL[B] =
    xs match {
      case Last(head) => Last(f(head))
      case More(head, tail) =>
        More(f(head),map(tail)(f))
    }

  println(toNEL(3,List(4,2,1)))
  println(map(toNEL(10,List(20,30)))(_+5))
}
