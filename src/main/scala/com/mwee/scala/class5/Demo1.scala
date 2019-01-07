package com.mwee.scala.class5

/**
  * Created by hwt on 2018/12/19.
  */
object Demo1 {

  //普通函数
  def fun1(name:String):String="hello"+name

  //高阶函数，带有函数参数的函数
  def someAction(f:(Double)=>Double)=f(10)

  def main(args: Array[String]): Unit = {
    Array(1,2,3).map(_*3).foreach(println)

    import scala.math._
    println(someAction(sqrt))
    println(myFunction(mytest,1,2))
  }

  def mytest(x:Int,y:Int):Int={
    x*y+100
  }

  def myFunction(f:(Int,Int)=>Int,x:Int,y:Int):Int={
    f(x,y)
  }

}
