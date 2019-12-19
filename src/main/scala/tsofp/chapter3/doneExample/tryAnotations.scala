package tsofp.chapter3.doneExample

import scala.util.{Failure, Success, Try}

object tryAnotations extends App{
  case class ErrorLibreria(nombre:String)
// Throwable is the general type of all exceptions, Failure and Success[A]
  println(Try("asdfas".toInt) match {
    case Failure(exception) => Left(ErrorLibreria(exception.getMessage))
    case Success(value) => Right(value)
  })


}
