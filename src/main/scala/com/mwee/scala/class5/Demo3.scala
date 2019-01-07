package com.mwee.scala.class5

/**
  * 柯里化函数：把具有多个参数的函数转换为一条函数链，每个节点上是单一参数
  * Created by hwt on 2018/12/20.
  */
object Demo3 {
    //一下两个函数等价
  def add1(x:Int,y:Int)=x+y
  def add2(x:Int)(y:Int)=x+y

  //以下三个函数相等
  //普通函数
  def mu(x:Int,y:Int)=x*y
  //柯里化函数
  def mu2(x:Int)=(y:Int)=>x*y
  //简写
  def mu3(x:Int)(y:Int)=x*y

  def main(args: Array[String]): Unit = {
    println(mu(1,2))
    println(mu3(1)(2))
  }

}
