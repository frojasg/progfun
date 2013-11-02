package week7
   
object test {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(79); 
  
  val problem = new Pouring(Vector(4,9, 19));System.out.println("""problem  : week7.Pouring = """ + $show(problem ));$skip(16); val res$0 = 
  problem.moves;System.out.println("""res0: scala.collection.immutable.IndexedSeq[Product with Serializable with week7.test.problem.Move] = """ + $show(res$0));$skip(23); val res$1 = 
  problem.solution(17);System.out.println("""res1: Stream[week7.test.problem.Path] = """ + $show(res$1))}
  
  
  
  
  
  

}