object list {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

val data = List("a", "a", "a", "b", "c", "c", "a")//> data  : List[java.lang.String] = List(a, a, a, b, c, c, a)
	def pack[T](xs: List[T]): List[List[T]] = xs match {
		case Nil => Nil
		case x :: xs1 =>
		val (first, rest) = xs span (y => x == y)
		first :: pack(rest)
	}                                         //> pack: [T](xs: List[T])List[List[T]]
	
	data.head                                 //> res0: java.lang.String = a
	val d = pack(data)                        //> d  : List[List[java.lang.String]] = List(List(a, a, a), List(b), List(c, c),
                                                  //|  List(a))
 
  
  d.map( l => (l.head, l.length))                 //> res1: List[(java.lang.String, Int)] = List((a,3), (b,1), (c,2), (a,1))
	
	
	
}