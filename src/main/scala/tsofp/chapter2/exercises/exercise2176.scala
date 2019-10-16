package tsofp.chapter2.exercises



object exercise2176 extends App{

  def f[P,Q](p: List[P],q:List[Q]):Map[Q,P]={
    q.zip(p).toMap
  }
  println(f[Boolean,Set[Int]](List(true,false,true,true),List(Set(3),Set(2),Set(4),Set(5))))
}
