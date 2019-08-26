package cn.lgwen

class Queue[T](){

  private var length: Long = 0
  private var front:Option[Node[T]] = None
  //private var front:T = null.asInstanceOf[T]
  private var last:Option[Node[T]] = None

  private var current: Long  = 0


  def this(length:Long) {
    this ()    //调用主构造函数
    this.length = length
  }


  def insert(node: T): Unit = {
    if (length != 0 && current >= length) {
      throw new RuntimeException()
    } else if (length != 0){
      current += 1
    }

    if (front.isEmpty || front.get == null) {
      front = Option.apply(new Node[T](node, null))
      return
    }
    val lastNode = new Node[T](node, null)
    if (front.get.next == null) {
      // 表示只有一个元素，则要将首个元素的next 设置成next
      front.get.next = lastNode
    }
    if (last.isEmpty || last.get == null) {
      last = Option.apply(lastNode)
    }
    last.get.next = lastNode
    last = Option.apply(lastNode)
  }

  def remove(): T = {
    if (front.get.node == null) {
      null.asInstanceOf[T]
    }
    val node:T = front.get.node
    val next: Node[T] = front.get.next
    if (next == null || node.equals(next.node)) {
      // 如果当前 first 和 next 节点是相同则这个 queue 只有一个 元素
      front = None
      last = None
    }
    if (length != 0 && current > 0) {
      current -= 1
    }
    front = Option.apply(next)
    node
  }

  def peekFront(): T = {
    if (front.get.node == null) {
      null.asInstanceOf[T]
    }
    front.get.node
  }


  class Node[T](var node: T, var next: Node[T]) {

  }


}


object T{
  def main(args: Array[String]): Unit = {
    var queue: Queue[Int] = new Queue[Int](5)
    queue.insert(1)
    queue.insert(2)
    queue.insert(3)
    queue.insert(4)
    queue.insert(4)
    println(queue.remove())
    queue.insert(4)
    println(queue.remove())
    println(queue.remove())
    println(queue.remove())
    println(queue.remove())
  }
}