package tsofp.chapter2.exercises

object exercise2522 extends App{
  val n:Double=19
  val result=LazyList.iterate(n){collatzValue(_)}.takeWhile(_>1).toList
  println(result:+1)
  def collatzValue(value:Double):Double={
    if(value==1) value
    else if(value%2==0) value/2
    else 3*value+1
  }
}
