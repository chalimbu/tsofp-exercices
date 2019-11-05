package tsofp.chapter2.doneExamples

object example25112 extends App{
  def longestNoDup[A](xs: Seq[A]):Seq[A]= {
    val init: (Seq[A], Seq[A]) = (Seq(), Seq())
    val (firs, last) = xs.foldLeft(init) { case ((first, current), x) =>
      val xWasRepeated = current != Seq() && current.last == x
      val firstIsLongerThanCurrent = first.length > current.length
      val newFirs = if (firstIsLongerThanCurrent) first else current
      val newCurrent = if (xWasRepeated) Seq(x) else current :+ x
      (newFirs, newCurrent)
    }
    if (firs.length > last.length) firs else last
  }
  println(longestNoDup(Seq(1,2,3,4,5,5,2,3,4,1,2)))
}
