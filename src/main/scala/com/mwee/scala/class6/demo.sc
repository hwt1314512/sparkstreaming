//更好的switch
var sign=0
var ch1:Char='-'
ch1 match {
  case '+'=>sign = 1
  case '-'=>sign = -1
    //_ 代表匹配其它的所有
  case _ => sign=0
}

sign

//Scala的守卫:在case语句中嵌套if语句
var ch2='1'
var digit:Int= -1
ch2 match{
  case '+'=>sign=1
  case '-'=>sign= -1
  case  _ if Character.isDigit(ch2)=>digit=Character.digit(ch2,10)
  case _   => sign=0
}


//模式匹配中的变量
var str3:String ="Hello World"
str3(7) match {
  case '+'=>println("+")
  case '-'=>println("-")
  case ch=>println(ch)
}

//类型模式
var v4:Any=100
v4 match {
  case x:Int=>println("int:"+v4)
  case s:String=>println("String"+v4)
  case _ =>println("other")
}

// 匹配数组和列表
var array=Array(1,2)
array match{
  case Array(x,y)=>println("two："+x+y)
    // 表示匹配多个元素
  case Array(x,_*)=>println("many")
}

















