object list {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(57); 
  println("Welcome to the Scala worksheet");$skip(52); 

val data = List("a", "a", "a", "b", "c", "c", "a");System.out.println("""data  : List[java.lang.String] = """ + $show(data ));$skip(160); 
	def pack[T](xs: List[T]): List[List[T]] = xs match {
		case Nil => Nil
		case x :: xs1 =>
		val (first, rest) = xs span (y => x == y)
		first :: pack(rest)
	};System.out.println("""pack: [T](xs: List[T])List[List[T]]""");$skip(13); val res$0 = 
	
	data.head;System.out.println("""res0: java.lang.String = """ + $show(res$0));$skip(20); 
	val d = pack(data);System.out.println("""d  : List[List[java.lang.String]] = """ + $show(d ));$skip(39); val res$1 = 
 
  
  d.map( l => (l.head, l.length));System.out.println("""res1: List[(java.lang.String, Int)] = """ + $show(res$1))}
	
	
	
}