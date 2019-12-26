package tsofp.chapter3.exercises

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.impl.Promise
import scala.util.{Failure, Success}

object exercise3426 extends App{
  val procedure: Unit => Unit={ Unit => println("hello")}

  sealed trait Proc
  case class Func[A](f: Unit => A) extends Proc
  case class Sequ(p1: Proc,p2: Proc) extends Proc
  case class Para(p1: Proc,p2: Proc) extends Proc

  def runner: Proc => Future[Unit] = {
    (procedure) =>
      procedure match {
        case Func(f) => {
          Future(f())
        }
        case Sequ(p1, p2) => {
          for(
            a <- runner(p1);
            b <- runner(p2)
          ) yield (b)
        }
        case Para(p1, p2) =>{
          val r1=runner(p1)
          val r2=runner(p2)
          for(a <- r1;b <- r2) yield b
        }
      }
  }

  val proc1: Proc = Func{_ => Thread.sleep(200);println("hello1")}
  val proc2: Proc = Func{_ => Thread.sleep(400);println("hello2")}

  val result: Future[Unit] =runner(Sequ(Para(proc2,proc1),proc2))
  //expeted hello1, hello2, hello2
  Await.result(result,Duration.Inf)
  result.onComplete {
    case Success(resp) => println("Resp: " + resp)
    case Failure(e) => println("Fail: " + e)
  }
}
