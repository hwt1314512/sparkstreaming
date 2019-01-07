package com.mwee.sparkSql

import java.sql.DriverManager

/**
  * 通过JDBC方式访问
  * Created by hwt on 2018/12/29.
  */
object SparkSqlThriftServerApp {
  def main(args: Array[String]): Unit = {
    Class.forName("org.apache.hive.jdbc.HiveDriver")
    val conn=DriverManager.getConnection("jdbc:hive2://dn1.hadoop.pdbd.test.cn:10000/;principal=hive/dn1.hadoop.pdbd.test.cn@MWEER.COM")
    val pstmt=conn.prepareStatement("select * from test.aaa")
    val rs = pstmt.executeQuery()
    while(rs.next()){
      println(rs.getString("id")+","+rs.getString("name")+","+rs.getString("flag"))
    }

    rs.close()
    pstmt.close()
    conn.close()
  }
}
