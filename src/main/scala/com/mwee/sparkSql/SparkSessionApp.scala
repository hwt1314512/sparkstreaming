package com.mwee.sparkSql

import org.apache.spark.sql.SparkSession

/**
  * Created by hwt on 2018/12/29.
  */
object SparkSessionApp {
  def main(args: Array[String]): Unit = {

    val path=args(0)

    var spark = SparkSession.builder().appName("SparkSessionApp").master("local[2]").getOrCreate()

    val people =spark.read.json(path)

    people.show()

    spark.stop()

  }

}
