package com.mwee.sparkSql.log

import org.apache.spark.sql.Row
import org.apache.spark.sql.types.{LongType, StringType, StructField, StructType}

/**
  *
  * 访问日志转换
  * Created by hwt on 2019/1/6.
  */
object AccessConvertUtils {
  val accessSchema = StructType(
    Array(
      StructField("url", StringType),
      StructField("cmsType", StringType),
      StructField("cmsId", LongType),
      StructField("traffic", LongType),
      StructField("ip", StringType),
      StructField("city", StringType),
      StructField("time", StringType),
      StructField("day", StringType)
    )
  )

  /**
    * 将访问日志转换为Row
    * @param log
    * @return
    */
  def parseAccessLog(log:String):Row={
    try{
      val access_array = log.split("\t")
      val time = access_array(0)
      val url = access_array(1)
      val traffic = access_array(2).toLong
      val ip = access_array(3)

      var cmsType=""
      var cmsId=0l
      var subUrl = ""
      if(!"-".equals(url)){
        subUrl = url.substring(url.indexOf("http://www.imooc.com/")+"http://www.imooc.com/".length)
      }
      if(subUrl.split("/").length>1){
        cmsType=subUrl.split("/")(0)
        cmsId=subUrl.split("/")(1).toLong
      }
      //todo 通过ip求city
      val city="weizhi"
      val day = time.substring(0,10).replaceAll("-","")

      Row(url,cmsType,cmsId,traffic,ip,city,time,day)
    }catch {
      case e:Exception=>{
        Row("","",0l,0l,"","","","")
      }
    }

  }

}
