package tsofp.chapter2.exercises

object exercise2178 extends App{


  def reorder[S](p: Seq[S],q: Seq[Int]):Seq[S] = {
    q.zip(p).sortBy({case(q,p)=>q}).toList.map({case(a,b)=>b})
  }

  println(reorder(Seq(6.0,2.0,8.0,4.0),Seq(20,10,40,30)))
}
