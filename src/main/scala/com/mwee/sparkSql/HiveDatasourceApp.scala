package com.mwee.sparkSql

import org.apache.spark.sql.SparkSession

/**
  * hive表数据的相关操作
  * Created by hwt on 2019/1/5.
  */
object HiveDatasourceApp {
  def main(args: Array[String]): Unit = {
    val spark  = SparkSession.builder().appName("ParquetApp").master("local[2]").getOrCreate()

    //查询所有表
    spark.sql("show tables")
    //查询某个表
    spark.table("tableName").show

    //配置分区shuffle分区数量，默认是200
    spark.sqlContext.setConf("spark.sql.shuffle.partitions","10")

    //写入hive表
    spark.sql("select * from tableName").write.saveAsTable("writeTableName")

    spark.stop()
  }
}
