package tsofp.chapter1

object exercisesMatchinFormula extends App{
  //1.6.1
  //machins formula
  //return the result in radians
  def arcTang12TermsOf1OverN(n: Int):Double={
    (0 to 12)
      .map(k=>(math.pow(-1D,k)/(2*k+1))*(math.pow(n,-2*k-1)))
      .sum
  }
  //testing the arcTang
  println(arcTang12TermsOf1OverN(2))
  //using the function to computate pi
  def piMachinsFormula:Double={
    4*(4*arcTang12TermsOf1OverN(5)-arcTang12TermsOf1OverN(239))
  }
  println(piMachinsFormula)
}
