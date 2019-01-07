package com.mwee.scala.class6

/**
  * Created by hwt on 2018/12/22.
  */
object Demo2 {
  def main(args: Array[String]): Unit = {
    //Vector:为了提高List集合随机存取效率而引入的新的集合类型
    //最大的特别就是支持快速的查找和更新
    var v =Vector(1,2,3,4,5)
    //find返回第一个满足条件的元素
    v.find(_>3)

    v.updated(2,100)

    //Range：有序的通过空格分割的Int序列
    //以下几种Range是一样的
    val r = Range(0,5)
    val r2 = 0 until 5
    val r3 = 0 to 4
    //range可以相加
    val r4=(0 to 9 )++('A' to 'Z')

    println(r)
    println(r2)
    println(r3)
    println(r4)

    //rang转list
//    val a=1 to 5 toList
//   val r5= 1 to 5 toList
//    println()

  }
}
