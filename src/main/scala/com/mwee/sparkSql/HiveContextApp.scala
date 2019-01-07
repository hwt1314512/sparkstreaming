package com.mwee.sparkSql

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.hive.HiveContext

/**
  * Created by hwt on 2018/12/29.
  */
object HiveContextApp {
  def main(args: Array[String]): Unit = {

    //常见相应的的Context
    val sparkConf=new SparkConf()
    //在测试或生产环境中，AppName和Master通过脚本控制
    //    sparkConf.setMaster("local[2]").setAppName("SQLContextApp")
    val sc = new SparkContext(sparkConf)
    val hiveContext = new HiveContext(sc)

    //进行相关的处理
    hiveContext.table("test.aaa").show

    //关闭资源
    sc.stop()
  }

}
