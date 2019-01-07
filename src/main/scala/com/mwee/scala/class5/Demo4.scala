package com.mwee.scala.class5

/**
  * Created by hwt on 2018/12/20.
  */
object Demo4 {

  def main(args: Array[String]): Unit = {
    //map:在列表总的每个元素上计算一个函数，返回一个包含相同元素的列表
//    val number = List(1,2,3,4,5,6)
//    val number2= number.map((i:Int)=>i*2)
//    println(number2.mkString(","))
//
//    //filter：过滤返回false的元素
//    val number3 = number.filter((i:Int)=>i%3==0)
//    println(number3.mkString(","))
//
//    //zip:把两个列表的元素合并成一个元素对的列表
//    val zip = List(1,2,3).zip(List(4,5,6))
//    println(zip.mkString(","))
//
//    //partition：根据断言函数的返回值对列表进行拆分
//    val partition=number.partition((i:Int)=>i%2==0)
//    println(partition.toString())
//
//    //find：返回集合中跟第一个匹配断言函数的元素
//    val find=number.find((i:Int)=>i%3==0)
//    println(find.toString)
//
//    //flatten:把嵌套的结构展开
//    val flatten=List(List(1,2,3),List(1,2,3)).flatten
//    println(flatten.toString())
//
//    //flatMap
//    val myList=List(List(1,2,3),List(1,2,3))
//    val flatMap=myList.flatMap(x=>x.map(_*2))
//    println(flatMap.toString())

    val s=List("1,2,3","4,5,6")
    val f = s.flatten
    println(f.toString())

  }


}
