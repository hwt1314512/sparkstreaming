package com.mwee.sparkSql

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext

/**
  * SparkContext使用
  * Created by hwt on 2018/12/29.
  */
object SQLContextApp {
  def main(args: Array[String]): Unit = {

    val path=args(0)
    //常见相应的的Context
    val sparkConf=new SparkConf()
    //在测试或生产环境中，AppName和Master通过脚本控制
//    sparkConf.setMaster("local[2]").setAppName("SQLContextApp")
    val sc = new SparkContext(sparkConf)
    val sqlContext = new SQLContext(sc)

    //进行相关的处理
    val people = sqlContext.read.format("json").load(path)
    people.printSchema()
    people.show()

    //关闭资源
    sc.stop()
  }
}
