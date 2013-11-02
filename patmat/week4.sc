object week4 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  val f = (x: Int) => x * x                       //> f  : Int => Int = <function1>
  f(2)                                            //> res0: Int = 4
  
  trait Exp
  case class Number(n:Int) extends Exp
  case class Sum(e1: Exp, e2: Exp) extends Exp
  
  
  def show(e: Exp): String = e match {
  	case Number(x) => x.toString
  	case Sum(l, r) => show(l) + " + " + show(r)
  }                                               //> show: (e: week4.Exp)String
  
  show(Number(1))                                 //> res1: String = 1
  show(Sum(Number(1),Number(2)))                  //> res2: String = 1 + 2
  
  List ("ola", "q", "ase")                        //> res3: List[java.lang.String] = List(ola, q, ase)
  "ola":: "q":: "ase" :: Nil                      //> res4: List[java.lang.String] = List(ola, q, ase)
  

	def merge(xs: List[Int], ys: List[Int]): List[Int] =
		xs match {
			case Nil =>
			  ys
			case x :: xs1 =>
				ys match {
				case Nil =>
					xs
				case y :: ys1 =>
				  if (x < y) x :: merge(xs1, ys)
					else y :: merge(xs, ys1)
		}
	}                                         //> merge: (xs: List[Int], ys: List[Int])List[Int]
	
	def merge2(xs: List[Int], ys: List[Int]): List[Int] =
	  (xs, ys) match {
	  	case (Nil, ys1) => ys1
	  	case (xs1, Nil) => xs1
	  	case (x::xs1, y::ys1) =>
	  		if (x < y) x :: merge2(xs1, ys)
	  		else y :: merge2(xs, ys1)
	  	
	  }                                       //> merge2: (xs: List[Int], ys: List[Int])List[Int]

  
  def msort(xs: List[Int]): List[Int] = {
		val n = xs.length/2
		if (n == 0) xs
		else {
			val (fst, snd) = xs splitAt n
			merge2(msort(fst), msort(snd))
		}
	}                                         //> msort: (xs: List[Int])List[Int]
	
	msort(List(3,1,2))                        //> res5: List[Int] = List(1, 2, 3)
	


	def squareList(xs: List[Int]): List[Int] = xs match {
    case Nil => xs
    case y :: ys => (y * y) :: squareList(ys)
  }                                               //> squareList: (xs: List[Int])List[Int]
  
  squareList(List(1,2,3))                         //> res6: List[Int] = List(1, 4, 9)
  
  def squareList2(xs: List[Int]): List[Int] =
    xs map (x => x*x)                             //> squareList2: (xs: List[Int])List[Int]
    
  squareList2(List(1,2,3))                        //> res7: List[Int] = List(1, 4, 9)


	val nums = List(-2, 1, 12, 5, 0, 9)       //> nums  : List[Int] = List(-2, 1, 12, 5, 0, 9)
	nums filter (x => x > 0)                  //> res8: List[Int] = List(1, 12, 5, 9)
	nums filterNot (x => x > 0)               //> res9: List[Int] = List(-2, 0)
	nums partition (x => x > 0)               //> res10: (List[Int], List[Int]) = (List(1, 12, 5, 9),List(-2, 0))
	nums takeWhile (x => x > 0)               //> res11: List[Int] = List()
	nums dropWhile (x => x > 0)               //> res12: List[Int] = List(-2, 1, 12, 5, 0, 9)
	nums span (x => x > 0)                    //> res13: (List[Int], List[Int]) = (List(),List(-2, 1, 12, 5, 0, 9))
	
	val data = List("a", "a", "a", "b", "c", "c", "a")
                                                  //> data  : List[java.lang.String] = List(a, a, a, b, c, c, a)
                                                  //| Output exceeds cutoff limit. 
	
	def pack[T](xs: List[T]): List[List[T]] = xs match {
		case Nil => Nil
		case x :: xs1 =>
		val (first, rest) = xs1 span (y => x == y)
		first::pack(rest)
	}
	
	pack(data);
	
	println("ola");
	
	//def encoding[T](xs: List[T]): List((T, Int)) = NiL
		
	
	
}
  
  