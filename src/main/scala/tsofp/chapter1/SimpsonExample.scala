package tsofp.chapter1

object SimpsonExample extends App{
  def integration(a: Double,b: Double,g: Double=> Double,eps: Double):Double={
    val n: Int=2*((b-a)/eps).toInt
    println(n)
    val delta_x=(b-a)/n

    val s1= (1 to (n-1) by 2).map(i=>g(a+i*delta_x)).sum
    val s2= (2 to (n-2) by 2 ).map(i=>g(a+i*delta_x)).sum
    (delta_x/3)*(g(a)+g(b)+(4*s1)+(2*s2))
  }
  //x=>x*x*x*x
  println(s"should be 625 and is ${integration(0,5,x=>x*x*x*x,eps=0.01)}")

}
