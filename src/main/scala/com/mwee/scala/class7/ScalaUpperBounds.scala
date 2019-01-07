package com.mwee.scala.class7

/**
  * 类型变量的上界：S<:T
  * S和T代表两种类型
  * 表示S必须是T的子类，T就叫S的上界
  * Created by hwt on 2018/12/23.
  */
//定义父类 Vehicle
class Vehicle{
  def drive()=println("Driving********************")
}
//Vehicle子类
class Car extends Vehicle{
  override def drive(): Unit = println("Car Driving******")
}
class Bicycle extends Vehicle{
  override def drive(): Unit = println("Bicycle Driving************")
}

object ScalaUpperBounds {

  def takeVehicle[T<:Car](v:T)={
    v.drive()
  }

  def main(args: Array[String]): Unit = {
//    var v:Vehicle=new Vehicle
    var c:Car = new Car
    takeVehicle(c)
  }
}
