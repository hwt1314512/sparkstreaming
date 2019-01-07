import scala.reflect.ClassTag
// scala的泛型函数

//普通类型的函数:Int
def mkIntArray(elems:Int*)=Array(elems:_*)
val a =mkIntArray(1,2,3)
//普通类型的函数：String
def mkStringArray(elems:String*)=Array(elems:_*)
val b =mkStringArray("4","5","6")
//泛型数组
def mkGenericArray[T:ClassTag](elems:T*)=Array(elems:_*)
mkGenericArray(1,2)
mkGenericArray("10","y")