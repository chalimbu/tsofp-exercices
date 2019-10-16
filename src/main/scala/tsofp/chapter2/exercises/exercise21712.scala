package tsofp.chapter2.exercises

object exercise21712 extends App{
  val transactions: Seq[Map[String,Int]]=Seq(Map("pedro"->3,"pedro"->2),
    Map("miquel"->2,"pedro"->5),Map("pedro"->3,"miguel"->2))

  def payments[Person,Amount](data: Seq[Map[Person,Amount]]): Map[Person,Seq[Amount]]= {
    data.flatMap(x=>x.toSeq).groupBy({case(person,amount)=>person})
      .map({case(a,b)=>{
        val bList: Seq[Amount] = b.map({case(c,d)=>d})
        (a,bList)
      }})

  }

  val result=payments(Seq(Map("Tarski"->10,"Church"->20),Map("Church"->100,"Gentzen"->40)
    ,Map("Tarski"->50)))
  println(result)
}
