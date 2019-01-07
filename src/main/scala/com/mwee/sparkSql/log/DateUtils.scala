package com.mwee.sparkSql.log

import java.text.SimpleDateFormat
import java.util.{Date, Locale}

import org.apache.commons.lang3.time.FastDateFormat


/**
  * 日期时间解析工具类
  * SimpleDataFormat是线程不安全的
  * Created by hwt on 2019/1/6.
  */
object DateUtils {
  val YYYYMMDDHHMM_TIME_FORMAT=FastDateFormat.getInstance("dd/MMM/yyyy:HH:mm:ss Z",Locale.ENGLISH)
  val TARGET_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss")

  /**
    * 获取时间
    * @param time
    */
  def parse(time:String)={
    TARGET_FORMAT.format(getTime(time))
  }

  /**
    * [10/Nov/2016:00:01:02 +0800]
    * 获取输入日志时间：Long类型
    * @param time
    * @return
    */
  def getTime(time:String)={
    try{
      YYYYMMDDHHMM_TIME_FORMAT.parse(time.substring(time.indexOf("[")+1,time.lastIndexOf("]")))
    }catch {
      case e:Exception=>{
        0l
      }
    }
  }

  def main(args: Array[String]): Unit = {
    println(parse("[10/Nov/2016:00:01:02 +0800] "))
  }
}
