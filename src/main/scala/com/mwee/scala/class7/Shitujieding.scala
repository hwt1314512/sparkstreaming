package com.mwee.scala.class7

/** 视图界定:"<%"
  * 比 "<:" 适用的范围更广，除了所有的子类型，还允许可以隐身式转换过去的类型
  * Created by hwt on 2018/12/23.
  */
object Shitujieding {
  //x和y可以是String和String的子类，也可以是可以转换为String的其它类型
  def addTwoString[T <% String](x:T,y:T)={
    println(x+"***"+y)
  }

  def main(args: Array[String]): Unit = {
    addTwoString(100,100)
  }

  implicit  def int2String(n:Int):String=n.toString
}
