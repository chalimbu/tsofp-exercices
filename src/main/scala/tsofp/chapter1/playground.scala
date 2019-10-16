package tsofp.chapter1

object playground extends App{
  def is_prime(n: Int)=(2 to n).forall(k=> n%k !=0 )
  println(is_prime(11))

  val listNumber=List(5,6,7,8,9)
  def countEvens(ln: List[Int]):Int={
    ln.
      map(x=> if(x%2==0) 1 else 0).
      sum
  }
  println(countEvens(listNumber))
  //exits => if predicate returns true for a least one value
  //filter
  //takeWhile
  println(List(1,2,3,4,5).takeWhile(x=>x<3))

  //improvements to is prime
  def isPrime2(number: Int):Boolean ={
    (1 to number).
      takeWhile(x=> x*x<=number).
      forall(x=>(number%x)!=0)
  }
  println(isPrime2(13))
}
