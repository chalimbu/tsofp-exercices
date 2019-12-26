package tsofp.chapter3.exercises
import cats.implicits._

object exercise3427 extends App{
  def f1[A,B]: Option [(A,B)] => (Option[A],Option[B]) =
    (value) => value match {
      case Some(value) => (value._1.some,value._2.some)
      case None =>(None,None)
    }

  def f2[A,B]: Either[A,B] => (Option[A],Option[B])=
    (value) => value match {
      case Left(value) => (value.some,None)
      case Right(value) => (None,value.some)
    }

  def f3[A,B,C]: Either[A,Either[B,C]] => Either[Either[A,B],C] =
    (value) => value match {
      case Left(a) =>  Either.left(Either.left(a))
      case Right(Left(b)) =>Either.left(Either.right(b))
      case Right(Right(c)) => Either.right(c)
    }
}
