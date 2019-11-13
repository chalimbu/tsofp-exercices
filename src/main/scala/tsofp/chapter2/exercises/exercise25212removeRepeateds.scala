package tsofp.chapter2.exercises

object exercise25212removeRepeateds extends App{
  //removeDups(Seq(1, 1, 1, 1, 5, 2, 2, 5, 5 ,5 ,5 ,5, 1),3)
  //List(1, 1, 1, 5, 2, 2, 5, 5, 5, 1)
  def removeDups[A](sequence: Seq[A],k: Int): Seq[A] = {
    //i need to save the previous element and a counter.
    val init: (A,Int,Seq[A])=(sequence.head,0,Seq())
    sequence.foldLeft(init){
      case ((prev,counter,sequenceInt),next)=>{
        if(prev==next){
          if(counter>=k){
            (prev,counter+1,sequenceInt)
          }else{
            (prev,counter+1,sequenceInt:+next)
          }
        }else{
          (next,0,sequenceInt:+next)
        }
      }
    }._3.tail
  }
  println(removeDups(Seq(1, 1, 1, 1, 5, 2, 2, 5, 5 ,5 ,5 ,5, 1),3))
  ////List(1, 1, 1, 5, 2, 2, 5, 5, 5, 1)
  //  List(1, 1, 5, 2, 2, 5, 5, 5, 5, 1)
}
