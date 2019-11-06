package tsofp.chapter2.exercises

object exercise2528 extends App{
  def revDigits(n: Int): Int = {
    LazyList.iterate(n){_/10}.takeWhile(_>0).map(_%10).toList.mkString("").toInt
  }
  println(revDigits(12345))
  //54321
}
