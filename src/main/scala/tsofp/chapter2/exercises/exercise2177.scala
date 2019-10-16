package tsofp.chapter2.exercises

object exercise2177 extends App{
  val p= Seq("say","yes","and","do")
  val q= Seq(10,-1,5,3)
  val result= q.zip(p).sortBy({case(q,p)=>q}).toList.map({case(a,b)=>b})
  println(result)
}
