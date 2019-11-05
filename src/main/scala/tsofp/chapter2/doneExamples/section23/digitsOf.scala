package tsofp.chapter2.doneExamples.section23

object digitsOf extends App{
  def digitsOf(n: Int): Seq[Int] ={
    LazyList.iterate(n){_/10}
      .takeWhile{_!=0}
      .map(_%10).toList.reverse
  }
  println(digitsOf(123452))
}
