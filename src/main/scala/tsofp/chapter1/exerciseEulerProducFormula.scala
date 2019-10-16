package tsofp.chapter1

object exerciseEulerProducFormula extends App{
  def isPrime2(number: Int):Boolean ={
    (2 to (number-1)).
      takeWhile(x=> x*x<=number).
      forall(x=>(number%x)!=0)
  }
  println(isPrime2(2))

  def riegmanZetaFunctionRighSide(s: Int=4,ls:Int=100)={
    (2 to ls).filter(v=>isPrime2(v))
        .map(p=>1/(1-math.pow(p,-s))).product

  }

  println(s"expected ${math.pow(math.Pi,4)/90} and was ${riegmanZetaFunctionRighSide(4,100)}")
}
