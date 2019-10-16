package tsofp.chapter2.exercises

object exercise2179 extends App{
  def shopList[S](buys: Seq[(S,Int)]):Map[S,Int]={
    buys.groupBy{case (a,b)=>a}.map{case(a,b)=>(a,b.map{case(c,d)=>d}.sum)}
  }//Map[S, Seq[(S, Int)]]
  println(shopList(Seq(("apple",2),("pear",3),("apple",5))))
}
