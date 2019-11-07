package tsofp.chapter2.exercises

object exercise25211 extends App{
  def largestInIntervalWithRestriction(li:Int,ls:Int)={
    (li to ls).filter(x=>{
      val digits=LazyList.iterate(x){_/10}.takeWhile(_>0).map(_%10).toList
      (!digits.contains(3) && !digits.contains(5) && !digits.contains(7))
    }).max
  }
  println(largestInIntervalWithRestriction(100,175))

  def sumOfDigits(li: Int,ls: Int)={
    val list=(li to ls)
    val sum=list.map{
      LazyList.iterate(_){_/10}.takeWhile(_>10).map(_%10).toList.sum
    }
    list.zip(sum).sortBy{case (element,sumOfDigist) => -sumOfDigist}.head._1
  }
  println(sumOfDigits(100,200))

  def isPerfect(n: Int):Boolean={
    val superiorLimit: Int =(n-1)
    (1 to superiorLimit).foldLeft(List[Int]()){
      case (list,next)=>
        if(n%next==0) list:+next
        else list
    }.sum == n
  }
  println(isPerfect(6))
  //true
  println(isPerfect(8))
  //false
  println((1 to 1000).filter(isPerfect))
  //this is taking to long studied the possibilite of save previous divisor and do from top to bottom
}
