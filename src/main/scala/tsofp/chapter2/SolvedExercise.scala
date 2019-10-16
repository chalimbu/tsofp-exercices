package tsofp.chapter2

object SolvedExercise extends App{
  val aSequence=Seq(3,2,32,12,20,10,120)
  def howManyBigger(aSequence: Seq[Int])={
    val altered= 0+:aSequence
    altered.zip(aSequence).tail.filter({ case (a,b)=> b>a}).size
  }
 println(howManyBigger(aSequence))
  //Given a sequencewords:Seq[String]of words, compute a sequence of typeSeq[(Seq[String],Int)], where each inner sequence contains all the words having thesame length,paired with the integer value showing that lengt
  val sequenceWords=Seq("!","HA","WERE","DA","MANE","0H")
  println(sequenceWords.groupBy(_.size).map({case(a,b)=>(b.toSeq,a)}).toSeq)
//Create a 10×10 multiplication table as a dictionary of typeMap[(Int,Int),Int].
val n:Int=3
  val result=(1 to n).flatMap(x=> (1 to n).map((x,_))).toList.map{case (k,b)=>{ (k,b)->k*b}}.toMap
  println(result)
}
