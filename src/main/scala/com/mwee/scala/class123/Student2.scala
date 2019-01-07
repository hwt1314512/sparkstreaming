package com.mwee.scala.class123

import scala.collection.mutable.ArrayBuffer

/**
  * scala自动为private属性生成getter和setter方法
  * 声明为val则只有get方法
  * Created by hwt on 2018/12/18.
  */
class Student2 {
  private var age:Int=20
  private val stuName:String="Tom"

  //对象私有成员
  private[this] val money:Int=10

  class Course(var courseName:String,var credit:Int)

  var courseList=new ArrayBuffer[Course]()

  def addNewCourse(courseName:String,credit:Int)={
    var c = new Course(courseName,credit)
    courseList+=c
  }

}
object Student2{
  def main(args: Array[String]): Unit = {
    var student = new Student2
    student.age=10 //自动生成的set方法
    student.age // 自动生成的get方法
    student.addNewCourse("chinese",2)
    student.addNewCourse("enlish",2)

    student.courseList.foreach(x=>println(x.courseName+x.credit))
  }
}
