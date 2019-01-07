package com.mwee.scala.class4

/**
  * scala中的包对象：变量、常量、方法、类、对象和trait
  * Created by hwt on 2018/12/19.
  */

package object MyPackage{
  var x:Int=0

  val y:String="hello"

  def sayHello():String="hello world"

  //类
  class MyTestClass{

  }
  //对象
  object MyTestObject{

  }
  //特质
  trait MyTestTrait{

  }
}

class Demo3{
  def method()={
    import com.mwee.scala.class4.MyPackage._
    val a=new MyTestClass
  }
}

object Demo3 {


}
