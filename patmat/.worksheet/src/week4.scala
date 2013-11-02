object week4 {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(58); 
  println("Welcome to the Scala worksheet");$skip(28); 
  val f = (x: Int) => x * x;System.out.println("""f  : Int => Int = """ + $show(f ));$skip(7); val res$0 = 
  f(2)
  
  trait Exp
  case class Number(n:Int) extends Exp
  case class Sum(e1: Exp, e2: Exp) extends Exp;System.out.println("""res0: Int = """ + $show(res$0));$skip(229); 
  
  
  def show(e: Exp): String = e match {
  	case Number(x) => x.toString
  	case Sum(l, r) => show(l) + " + " + show(r)
  };System.out.println("""show: (e: week4.Exp)String""");$skip(21); val res$1 = 
  
  show(Number(1));System.out.println("""res1: String = """ + $show(res$1));$skip(33); val res$2 = 
  show(Sum(Number(1),Number(2)));System.out.println("""res2: String = """ + $show(res$2));$skip(30); val res$3 = 
  
  List ("ola", "q", "ase");System.out.println("""res3: List[java.lang.String] = """ + $show(res$3));$skip(29); val res$4 = 
  "ola":: "q":: "ase" :: Nil;System.out.println("""res4: List[java.lang.String] = """ + $show(res$4));$skip(248); 
  

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
	};System.out.println("""merge: (xs: List[Int], ys: List[Int])List[Int]""");$skip(238); 
	
	def merge2(xs: List[Int], ys: List[Int]): List[Int] =
	  (xs, ys) match {
	  	case (Nil, ys1) => ys1
	  	case (xs1, Nil) => xs1
	  	case (x::xs1, y::ys1) =>
	  		if (x < y) x :: merge2(xs1, ys)
	  		else y :: merge2(xs, ys1)
	  	
	  };System.out.println("""merge2: (xs: List[Int], ys: List[Int])List[Int]""");$skip(168); 

  
  def msort(xs: List[Int]): List[Int] = {
		val n = xs.length/2
		if (n == 0) xs
		else {
			val (fst, snd) = xs splitAt n
			merge2(msort(fst), msort(snd))
		}
	};System.out.println("""msort: (xs: List[Int])List[Int]""");$skip(22); val res$5 = 
	
	msort(List(3,1,2));System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(128); 
	


	def squareList(xs: List[Int]): List[Int] = xs match {
    case Nil => xs
    case y :: ys => (y * y) :: squareList(ys)
  };System.out.println("""squareList: (xs: List[Int])List[Int]""");$skip(29); val res$6 = 
  
  squareList(List(1,2,3));System.out.println("""res6: List[Int] = """ + $show(res$6));$skip(71); 
  
  def squareList2(xs: List[Int]): List[Int] =
    xs map (x => x*x);System.out.println("""squareList2: (xs: List[Int])List[Int]""");$skip(32); val res$7 = 
    
  squareList2(List(1,2,3));System.out.println("""res7: List[Int] = """ + $show(res$7));$skip(39); 


	val nums = List(-2, 1, 12, 5, 0, 9);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(26); val res$8 = 
	nums filter (x => x > 0);System.out.println("""res8: List[Int] = """ + $show(res$8));$skip(29); val res$9 = 
	nums filterNot (x => x > 0);System.out.println("""res9: List[Int] = """ + $show(res$9));$skip(29); val res$10 = 
	nums partition (x => x > 0);System.out.println("""res10: (List[Int], List[Int]) = """ + $show(res$10));$skip(29); val res$11 = 
	nums takeWhile (x => x > 0);System.out.println("""res11: List[Int] = """ + $show(res$11));$skip(29); val res$12 = 
	nums dropWhile (x => x > 0);System.out.println("""res12: List[Int] = """ + $show(res$12));$skip(24); val res$13 = 
	nums span (x => x > 0);System.out.println("""res13: (List[Int], List[Int]) = """ + $show(res$13));$skip(54); 
	
	val data = List("a", "a", "a", "b", "c", "c", "a");System.out.println("""data  : List[java.lang.String] = """ + $show(data ));$skip(161); 
	
	def pack[T](xs: List[T]): List[List[T]] = xs match {
		case Nil => Nil
		case x :: xs1 =>
		val (first, rest) = xs1 span (y => x == y)
		first::pack(rest)
	};System.out.println("""pack: [T](xs: List[T])List[List[T]]""");$skip(15); val res$14 = 
	
	pack(data);System.out.println("""res14: List[List[java.lang.String]] = """ + $show(res$14));$skip(19); ;
	
	println("ola");}
	
	//def encoding[T](xs: List[T]): List((T, Int)) = NiL
		
	
	
}
  
  