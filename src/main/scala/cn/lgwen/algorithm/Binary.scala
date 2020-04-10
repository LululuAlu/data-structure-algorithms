package cn.lgwen.algorithm

import java.util.Comparator

/**
  * 2019/9/3
  * aven.wu
  * danxieai258@163.com
  * 使用递归实现二分查找
  */
class Binary {

  /**
    *
    * @param array 被查找的数组
    * @param obj 目标值
    * @param comparator
    * @return 索引位置
    */
  def BinarySearch[T](array: Array[T], obj: T, comparator: Comparator[T]): Int = {
    if (array == null || array.length == 0) {
      return null.asInstanceOf[Int]
    }
    null.asInstanceOf[Int]
  }

  def search(array: Array[Int], target: Int, index:Int = 1): Int = {
    if (array.length == 1) {
      val i = if (array(0) == target) 0 else null.asInstanceOf[Int]
      return i + index
    }
    val middle:Int = array.length/2
    val minArray: Array[Int] = new Array[Int](middle)
    array.copyToArray(minArray, 0, middle)
    val maxArray: Array[Int] = new Array[Int](array.length - middle)
    System.arraycopy(array, middle, maxArray, 0, array.length - middle)
    if (array(middle) >= target) {
      search(minArray, target, index)
    } else {
      search(maxArray, target, middle + index)
    }
  }

}
object A {
  def main(args: Array[String]): Unit = {
    val binary: Binary = new Binary
    val array: Array[Int] = Array[Int](1,2,3,4,5,6,7)
    println(binary.search(array, 3))
    println(binary.search(array, 4))
    println(binary.search(array, 5))
    println(binary.search(array, 7))
    println(binary.search(array, 1))
    println(binary.search(array, 2))


  }
}
