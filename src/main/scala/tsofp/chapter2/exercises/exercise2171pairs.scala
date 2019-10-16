package tsofp.chapter2.exercises

object exercise2171pairs extends App{
  //Find all pairsi,jwithin(0, 1, ..., 9)such thati+4∗j>i∗j.Hint: use.flatMapand.filter.
  val resul=(1 to 9).flatMap(x=>(1 to 9).map(y=>(x,y)))
      .toSeq.filter{case (i,j)=> (i+(4*j))>i*j}
  println(resul)
}
