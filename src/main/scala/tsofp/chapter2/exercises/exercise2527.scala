package tsofp.chapter2.exercises

object exercise2527 extends App{
  def revSentence(s:String): String = {
    s.split(" ").reverse.mkString(" ")
  }
  println(revSentence("A quick brown fox"))
}
