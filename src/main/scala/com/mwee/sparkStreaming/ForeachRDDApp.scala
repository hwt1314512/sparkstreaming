package com.mwee.sparkStreaming

import java.sql.DriverManager

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * 使用Spark Streaming 完成有状态统计，并将结果写入到mysql中
  * Created by hwt on 2018/12/15.
  */
object ForeachRDDApp {
  def main(args: Array[String]): Unit = {
    val sparkConf = new SparkConf().setMaster("local[2]").setAppName("ForeachRDDApp")
    val ssc = new StreamingContext(sparkConf,Seconds(2))

    val lines = ssc.socketTextStream("dn2.hadoop.pdbd.mwbyd.cn",6789)
    val result = lines.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_)

    result.foreachRDD(rdd=>{
      rdd.foreachPartition(partitionOfRecords=>{
            val connection = createConnection()
            partitionOfRecords.foreach(pair=>{
              val sql="insert into wordcount(word,wordcount) values('"+pair._1+"','"+pair._2+"')"
              connection.createStatement().execute(sql)
            })
          connection.close()
      })

//      val connection = createConnection()
//      rdd.foreach(record=>{
//        val sql="insert into wordcount(word,wordcount) values('"+record._1+"','"+record._2+"')"
//        connection.createStatement().execute(sql)
//      })
    })

    ssc.start()
    ssc.awaitTermination()

  }
  def createConnection()={
    Class.forName("com.mysql.jdbc.Driver")
    DriverManager.getConnection("jdbc:mysql://10.0.19.6:30242/test","pd_test_dev","VFR5rgdf")

  }
}
