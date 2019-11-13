package tsofp.chapter2.exercises

object exercise25211PerfectNumbers extends App{
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
    findDivisor(n).sum == n
  }
  def findDivisor(n: Int):Set[Int]={
    val superiorLimit: Int =if (n<10)(n-1) else n/2
    (1 to superiorLimit).foldLeft(Set[Int]()){
      case (list,next)=>
        if(n%next==0) list+next
        else list
    }
  }

  def findAllDivisorTo(ls: Int): Map[Int,Set[Int]]= {
    val result=Map[Int,Set[Int]]()
    val valuesDivisors=(1 to ls/2).toList
    val initMultiplesOfTwo: (Int,Int)=(1,2)

    valuesDivisors.foldLeft(result){case (prev,nextExterior)=>{
      val multiplesOfNext=LazyList.iterate(initMultiplesOfTwo){
        case (multiplicator,value)=>{
          (multiplicator + 1,nextExterior * multiplicator)
        }
      }.takeWhile(x=>x._2<=ls).collect{case (_,a)=>a}.toList.tail
      multiplesOfNext.foldLeft(prev){
        case(prev,next)=>{
          val asdfas: Map[Int, Set[Int]] =prev
          val asdfasdfsw: Int =next
          addDivisor(nextExterior,next,prev)
        }
      }
    }}

  }
  def addDivisor(divisor: Int,number: Int,actual: Map[Int,Set[Int]]):Map[Int,Set[Int]]={
    if(divisor==1 || divisor!=number) {
      if (actual.contains(number)) {
        actual.updated(number, actual(number) + divisor)
      } else {
        actual + (number -> Set(divisor))
      }
    }else{
      actual
    }
  }

  def perfecsTo(ls: Int):Set[Int]={
    findAllDivisorTo(1000000).filter{case (number,divisors)=>{
      val asdfas: Int =number
      val diasdfa: Set[Int] =divisors
      divisors.sum==number
    }}.keySet
  }

  println(isPerfect(6))
  //true
  println(isPerfect(8))
  //false
  println(isPerfect(496))
  //true
  println(isPerfect(8128))
  //val divisorsWithKeys=findAllDivisorTo(1000000)
  //println(divisorsWithKeys.get(6))
  //println(divisorsWithKeys.get(28))
  //println(divisorsWithKeys.get(496))
  //println("findAllDivisor"+findAllDivisorTo(1000000).get(20))
  println("perfects to"+perfecsTo(1000000).toString())
  //this is taking to long studied the possibilite of save previous divisor and do from top to bottom
}
