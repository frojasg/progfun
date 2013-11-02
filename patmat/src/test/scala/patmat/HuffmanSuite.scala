package patmat

import org.scalatest.FunSuite
import scala.util.Sorting

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }
  
  test("count number of time a char appear") {
    assert(times(List('a', 'b', 'a')) === List(('b', 1), ('a', 2)))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }
  
  test("singleton") {
    new TestTrees {
    	assert(singleton(List(t1)))
    	assert(!singleton(List(t1, t2)))
    }
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }
  
  test("until ") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(until(singleton, combine)(leaflist) === List(Fork(Fork(Leaf('e',1),Leaf('t',2), List('e', 't'), 3), Leaf('x',4), List('e', 't', 'x'), 7)))
  }
  
  test("createCodeTree") {
    assert(createCodeTree(List('a', 'b', 'a')) === Fork(Leaf('b',1),Leaf('a',2), List('b', 'a'), 3))
  }
  
  test("decode2") {
    assert(decode(createCodeTree(List('a', 'b', 'a')), List(1,0)) === List('a', 'b'))
  }
  
  test("encode2") {
    assert(quickEncode(frenchCode)(List('e', 'n', 'c', 'o', 'r', 'e', 'u', 'n', 't', 'e', 'x', 't', 'e', 't', 'r', 'e', 's', 's', 'e', 'c', 'r', 'e', 't')) === List(1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1))
  }
  
  test("combine with duplicate element") {
    assert(combine(List(Leaf('e',1))) === List(Leaf('e',1)))
  }
  test("combine order") {
    assert(combine(List(Leaf('e',4),Leaf('f',5), Leaf('g',6))) === List(Leaf('g', 6), Fork(Leaf('e',4), Leaf('f',5), List('e', 'f'), 9)))
  }
  test("combine two forks") {
    assert(combine(List(Fork(Leaf('e',4),Leaf('f',5), List('e','f'), 9), Fork(Leaf('a',6),Leaf('b',7), List('a','b'), 13))) === List(Fork(Fork(Leaf('e',4),Leaf('f',5),List('e', 'f'),9),Fork(Leaf('a',6),Leaf('b',7),List('a', 'b'),13),List('e', 'f', 'a', 'b'),22)))
  }
  
  
  test("createCodeTree works") {
    assert(createCodeTree(string2Chars("ttexxx")) === Fork(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',3), List('e', 't', 'x'),6))
    assert(createCodeTree(string2Chars("AAAAA")) === Leaf('A',5))
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }
}
