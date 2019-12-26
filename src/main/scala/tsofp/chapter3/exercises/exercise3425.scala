package tsofp.chapter3.exercises
import cats.implicits._

object exercise3425 extends App{
  case class Subscriber(name: String,email: String,phone: Option[Long])

  val listSubscriber=List(Subscriber("pedro","pedro@gmail.com",34324234L.some),Subscriber("miguel","miguel@gmail.com",None),
    Subscriber("pablo","pablo@gmail.com",None))

  println(listSubscriber.filter(pf=>pf.phone.isEmpty).map(x=>x.email))
}
