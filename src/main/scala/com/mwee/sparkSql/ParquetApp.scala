package com.mwee.sparkSql

import org.apache.spark.sql.SparkSession

/**
  * Parquet文件操作
  * Created by hwt on 2019/1/5.
  */
object ParquetApp {
  def main(args: Array[String]): Unit = {
    val spark  = SparkSession.builder().appName("ParquetApp").master("local[2]").getOrCreate()

    val userDF  = spark.read.parquet(Contants.dataPath+"users.parquet")
    userDF.printSchema()
    userDF.show()

//    userDF.createOrReplaceTempView("users")
//    val writeDF=spark.sql("select name,favorite_color from users")
    userDF.select("name","favorite_color").show
    //以json格式写入文件，保存结果到该目下，需要确保该目录不存在
//    userDF.select("name","favorite_color").write.format("json").save(Contants.dataPath+"jsonOutput" )

      //没有指定format则默认为parquet
    spark.read.load(Contants.dataPath+"users.parquet").show()

    spark.stop()
  }
}
