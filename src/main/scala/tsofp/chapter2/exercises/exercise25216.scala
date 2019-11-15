package tsofp.chapter2.exercises

import scala.annotation.tailrec

object exercise25216 extends App{
  def commonInt(xs: Seq[Int],ys: Seq[Int]): Seq[Int] = {
    @tailrec
    def commonIntInt(xs: Seq[Int],ys: Seq[Int],common: Seq[Int]=Seq()):Seq[Int]={
      if(xs.isEmpty || ys.isEmpty){
        common
      }else{
        if (xs.head == ys.head) {
          commonIntInt(xs.tail, ys.tail, common :+ xs.head)
        } else {
          if (xs.head > ys.head) {
            commonIntInt(xs, ys.tail, common)
          } else {
            commonIntInt(xs.tail, ys, common)
          }
        }
      }
    }
    commonIntInt(xs,ys)
  }

  println(commonInt(Seq(1,3,5,7),Seq(2,3,4,6,7,8)))

}
