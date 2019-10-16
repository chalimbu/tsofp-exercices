package tsofp.chapter2.exercises

object exercise2178reorder extends App{
  def reorder[P](p: Seq[P],s: Seq[Int]):Seq[P] = {
    p.zip(s).sortBy{case (a,b)=>b}.map{case (a,b)=>a}
  }
  println(reorder(Seq("as","asd","321"),Seq(3,2,1)))
}
