package cn.lgwen.structure

import java.util.Comparator

/**
  * aven.wu
  * danxieai258@163.com
  */
class SortList[T]{

  private var front:Option[Node[T]] = None
  //private var front:T = null.asInstanceOf[T]

  // mark last element
  private var lastNode:Option[Node[T]] = None

  private var comparator: Comparator[T] = null

  def this(comparator: Comparator[T]){
    this()
    this.comparator = comparator
  }


  def add(element: T): Unit ={
    if (front.isEmpty) {
      front = Option.apply(new Node[T](element, null))
      lastNode = Option.apply(new Node[T](null.asInstanceOf[T],
        new Node[T](element, null)))
      return
    }
    var node: Node[T] = front.get
    var perNode: Node[T] = front.get
    if (comparator.compare(element, node.node) < 0) {
      front = Option.apply(new Node[T](element, node))
      return
    }
    while (node != null && comparator.compare(element, node.node) > 0) {
      perNode = node
      node = node.next
    }
    if (node != null) {
      perNode.next = new Node[T](element, node.next)
    } else {
      perNode.next = new Node[T](element, null)
    }
  }

  def remove(): T ={
    if (front.isEmpty) {
      null.asInstanceOf[T]
    }
    val node: Node[T] = front.get
    if (node.next == null) {
      front = None
      lastNode = None
    }
    front = Option.apply(front.get.next)
    node.node
  }

  def remove(index: Int): T ={
    if (front.isEmpty || (front.get.next == null && index > 0)) {
      throw new IllegalArgumentException("out of index")
    }
    val node: Node[T] = front.get
    if (node.next == null) {
      front = None
      lastNode = None
    }
    var idx: Int = 0
    var no: Node[T] = front.get
    var perNode: Node[T] = no
    while (idx < index && no != null) {
      perNode = node
      no = no.next
      idx += 1
    }
    if (no != null) {
      perNode.next = no.next
      front = Option.apply(front.get.next)
      no.node
    } else {
      throw new IllegalArgumentException("out of index")
    }
  }

  def get(index: Int):T ={
    if (front.isEmpty || (front.get.next == null && index > 0)) {
      throw new IllegalArgumentException("out of index")
    }
    val node: Node[T] = front.get
    var idx: Int = 0
    var no: Node[T] = front.get
    var perNode: Node[T] = no
    while (idx < index && no != null) {
      perNode = node
      no = no.next
      idx += 1
    }
    if (no != null) {
      no.node
    } else {
      throw new IllegalArgumentException("out of index")
    }
  }

}

object A {

  def main(args: Array[String]): Unit = {
    val list: SortList[Int] = new SortList[Int](new Comparator[Int] {
      override def compare(o1: Int, o2: Int): Int = {
        o1 - o2
      }
    })
    list.add(3)
    list.add(5)
    list.add(1)
    list.add(7)

    println(list.get(0))
    println(list.remove(0))
    println(list.get(1))
    println(list.get(2))



  }

}

