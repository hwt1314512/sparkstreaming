package com.mwee.sparkSql

import org.apache.spark.sql.SparkSession

/**
  * Created by hwt on 2019/1/3.
  */
object DataSetApp {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().appName("DataSetApp").master("local[2]").getOrCreate()

    import spark.implicits._

    //spark如何解析CSV文件
    val df = spark.read.option("header","true").option("inferSchema","true").csv("D:\\data\\sales.csv")
    df.show()

    val ds = df.as[Sales]
    ds.map(line=>line.itemId).show()

    spark.stop()
  }

  case class Sales(transactionId:Int,customerId:Int,itemId:Int,amounttPaid:Double)

}
