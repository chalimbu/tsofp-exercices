package tsofp.chapter2.doneExamples

object binSearch extends App{
  def binSearch(xs:Seq[Int],goal: Int)(left: Int=0,right: Int=xs.length):Int ={
    if(right-left<=1||xs(left)==goal) left
    else{
      val middle=(left+right)/2
      val (newLeft,newRight)=
        if(goal<xs(middle)) (left,middle)
        else(middle,right)
      binSearch(xs,goal)(newLeft,newRight)
    }
  }
  println(binSearch((1 to 20),13)())
}
