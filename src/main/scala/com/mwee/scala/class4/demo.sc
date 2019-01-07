import java.io.{File, FileInputStream, PrintWriter}

//val source = scala.io.Source.
//  fromFile("U:\\Scala编程语言视频教程\\4-05-Scala中文件的访问\\hello.txt")
//整个文件作为一个字符串处理
//source.mkString

//处理每一行的数据
//val lines=source.getLines()
//for(s<-lines)println(s.toString)

// 字符
//for(c<-source)println(c)

//从URL上或者 源读取
//val source2=scala.io.Source.
//  fromURL("http://www.baidu.com","UTF-8")
//println(source2.mkString)

//读取二进制文件：Scala中没有单独读取二进制的方法
//val file = new File("U:\\Scala编程语言视频教程\\4-05-Scala中文件的访问\\hello.txt")
//val in=new FileInputStream(file)
//val buffer=new Array[Byte](file.length().toInt)
//in.read(buffer)
//in.close()

val out=new PrintWriter("U:\\Scala编程语言视频教程\\4-05-Scala中文件的访问\\hello.txt")
for(i<-1 to 10)out.print(i)
out.close()