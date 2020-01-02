package tsofp.chapter4

object formOfDefineCurriedFunction extends App{
  def logWith1(prefix: String)(message: String): Unit = println(s"$prefix $message")
  def logWith2(prefix: String): String => Unit = {message => println(s"$prefix $message")}
  def logWith3: String => String => Unit = { prefix => message => println(s"$prefix $message")}

  val INFO_LOG: String => Unit =logWith3("INFO")
  INFO_LOG(" table created")
}
