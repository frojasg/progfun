package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c <= 0 || c >= r)
      1
    else
      pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def countParentheses(chars: List[Char], count: Int): Boolean = {
      if (chars.isEmpty || count < 0)
        count == 0
      else {
        if (chars.head == '(')
          countParentheses(chars.tail, count + 1)
        else if (chars.head == ')')
          countParentheses(chars.tail, count - 1)
        else
          countParentheses(chars.tail, count)
      }
    }
    countParentheses(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def sum(count: Int, list: List[Int]): Int = {
      if (count > money)
        0
      else if (count == money)
        1
      else if (list.tail.isEmpty)
        sum(count + list.head, list)
      else
        sum(count + list.head, list) + sum(count, list.tail)
    }

    if (money == 0 || coins.isEmpty)
      0
    else
      sum(0, coins)
  }
}
