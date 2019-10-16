package tsofp.chapter2.exercises

object Exercise2172 extends App{
  //proced to generate the thre values i,j,k  within 0-9
  val values=(0 to 9).flatMap(i=>(0 to 9).flatMap(j=>(0 to 9 ).map(k=>(i,j,k)))).toList
  val filtering=values.filter{case (i,j,k)=>{i+4*j+9*k>i*j*k}}
  println(filtering)
}
