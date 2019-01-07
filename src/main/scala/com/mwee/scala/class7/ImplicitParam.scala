package com.mwee.scala.class7

/**
  * scala的隐式参数:用implicit 声明的参数
  * Created by hwt on 2018/12/23.
  */

object ImplicitParam {

  implicit val name="xxxxx"

  def testParamerte(implicit name:String)={
    println(name)
  }

  def smaller[T](a:T,b:T)(implicit ordere:T=>Ordered[T])=if(ordere(a)<b)  a else b

  def main(args: Array[String]): Unit = {
    testParamerte("Tom")
    testParamerte
    //利用隐式参数完成隐式转化
    //找到两个值中较小的那个值
    //如：100 12->12
    // abcd a->a
    println(smaller(100,12))
    println(smaller("aaa","ababa"))
  }

}
