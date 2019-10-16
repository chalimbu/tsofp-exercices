package tsofp.chapter1

object solvedExercises extends App{
  val result: Option[Double]= (1 to 10)
    .map(k=>math.abs(math.sin(k+2))).reduceLeftOption(_*_)
  println(result.getOrElse(0))
  val result2= (1 to 10)
    .map(k=>math.abs(math.sin(k+2))).product
  println(result2)
  //exercise 1.4.13
  val result3=(1 to 10)
    .filter(x=>math.cos(x)>0)
    .map(k=>math.sqrt(math.cos(k)))
    .sum
  println(result3)
  def average(list:List[Double])={
    list.sum/list.size
  }
  def wallisProduct(n: Int):Double={
    (1 to n).map(n=>((2*n).toDouble/(2*n-1))*((2*n).toDouble/(2*n+1))).product
  }
  println(math.cos(wallisProduct(10000))) // 12 240  10080 725760
  println(math.cos(wallisProduct(100000)))

  //example 1.4.1.6
  def numericallyCheck(n:Int)={
    (1 to n).map(k=>1.toDouble/(k*k)).sum
  }
  println(s"expectated${(Math.PI*Math.PI)/6} should be ${numericallyCheck(1000)}")
  //example 1.4.1.8
  def p(parameters:List[Int],f: Int=>Int ) ={
    parameters.map(f).max
  }
  println(p(List(2,3,5,2,3),(value: Int)=>{value*4}))

  //example 1.4.2.1
  //given a list[List[]] return the ones that have a size of at least 3
  def aLeast3(list: List[List[Int]]): List[List[Int]]={
    list.filter(_.size>=3)
  }
  val result5=aLeast3(List(List(3,2),List(3,2,4,5),List(1),List(3,1,2),List(2,2),List(3,2)))
  println(result5)
  //example 1.4.2.2
  //Find all integers k∈[1, 10]such that there are at least three different
  // integersj,where 1≤j≤k, each j satisfying the conditionj*j>2k
  val result6=(1 to 10)
    .filter(k=>
      (1 to k).filter(j=>j*j>2*k).size>=3
    )
    println(result6)
}
