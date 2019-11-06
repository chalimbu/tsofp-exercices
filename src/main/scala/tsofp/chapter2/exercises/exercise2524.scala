package tsofp.chapter2.exercises

object exercise2524 extends App{
  def prod3(a: Set[Int],b: Set[Int],c: Set[Int]):Set[Set[Int]]= {
    val result: Set[Set[Int]] =a.flatMap(av=>{b.flatMap(bv=>c.map(Set(av,bv,_)))})
    result
  }

  println(prod3(Set(1,2),Set(3),Set(4,5)))
  //Set(Set(1,3,4), Set(1,3,5), Set(2,3,4) Set(2,3,5))
}
