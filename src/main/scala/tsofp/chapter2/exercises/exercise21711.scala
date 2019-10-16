package tsofp.chapter2.exercises

object exercise21711 extends App{
  val p=Set(3,2,1,4,5,7,9)
  val q=Set(2,6,7,1,4,10,8)
  val newSet=q.flatMap(x=>q.map(y=>(x,y)))
  println(newSet)

  def cartesian[I,J](p:Set[I],q:Set[J]):Set[(I,J)]={
    p.flatMap(x=>q.map(y=>(x,y)))
  }
  println(cartesian(Set("a","b"),Set(10,20)))
}
