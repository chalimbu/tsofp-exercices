package tsofp.chapter2.exercises

object exercise2521 extends App{
  def digitsMapSum(x: Int)(f: Int=>Int): Int = {
    LazyList.iterate(x){_/10}
      .takeWhile{_!=0}
      .map(_%10).map(f).sum
  }

  println(digitsMapSum(123){x=>x*x})
  //Int 14

  println(digitsMapSum(123){x=>x*x*x})
  //36
}
