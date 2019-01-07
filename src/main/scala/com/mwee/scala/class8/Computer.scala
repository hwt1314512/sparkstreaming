//package com.mwee.scala.class8
//
//import scala.actors.{Actor, Channel, OutputChannel}
//
///**
//  * Created by hwt on 2018/12/25.
//  */
//
////创建自己的消息,1.处理的输入数据 2.消息通道(将结果发送到channel中)
//case class MyMessage(intpuData:Int,outputChannel:OutputChannel[Int])
//
//class Computer extends Actor{
//  override def act(): Unit = {
//    //接受消息-》处理消息-》将结果发送到一个channel中
//    while(true){
//      receive{
//        case MyMessage(inputData,outputChannel)=>{
//          //处理消息
//          val result = inputData*10
//          //将结果发送给channel
//          outputChannel ! result
//        }
//      }
//    }
//  }
//}
//
//object Computer{
//  def main(args: Array[String]): Unit = {
//    //创建channel
//    val channel = new Channel[Int]
//
//    //创建actor并启动
//    var computer=new Computer
//    computer.start()
//
//    //发送消息
//    computer ! MyMessage(11,channel)
//
//    //通过channel获取处理后的结果
//    channel.receive {
//      case 110 => println("success")
//    }
//
//  }
//}