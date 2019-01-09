package com.mwee.scala.class5

/**
  * 闭包：在一个函数定义中，包含了另一个函数的定义，内函数可以访问外函数
  * Created by hwt on 2018/12/20.
  */
object Demo2 {
    def main(args: Array[String]): Unit = {
        val triple = mulBy(3)
        val half = mulBy(0.5)
        println(triple(10))
        println(half(8))
    }

    //闭包mulBy(factor:Double)为第一个函数
    //(x:Double)为第二个函数
    def mulBy(factor: Double) = {
        (x: Double) => x * factor
    }
}
