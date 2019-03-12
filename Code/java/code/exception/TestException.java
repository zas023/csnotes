/*
*测试异常
*/
public class TestException{
	public static void main(String[] args) {
		//ArithmeticException：
		//int i=1/0; 
		//Exception in thread "main" java.lang.ArithmeticException: / by zero
        //at TestException.main(TestException.java:6)

        // try{
        // 	Thread.sleep(3000);
        // } catch(InterruptedException e){

        // }


        //NullPointerException :空指针异常
        Car c=null;
        if(c!=null){
        	c.start();
        }

        //ClassCastException：类型转换异常
        if (c instanceof Car) {
        	Car car = (Car) c;
        }

        //ArrayIndexOutOfBoundsException：数组边界异常

        //NumberFormatException：数字格式异常
        // String str = "1234abc";
        // Integer i=new Integer(str);
	}

}

class Car{
	void start(){
		System.out.println("启动！");
	}
}

/*异常：是Java提供的用于程序中处理错误的一种机制
  
  Java采用面向对象的方式来处理异常，其过程：
  1. 抛出异常： 在执行一个方法时，如果发生异常，则这个方法生成代表这个异常的对象，
               停止当前执行路径，并把异常提交个JRE。

  2. 捕获异常： JRE获得异常后，寻找相应的代码来处理该异常。JRE在方法的调用栈中查
               找，从生成异常的地方开始回溯，知道找到相应的异常处理代码为止。
*/

//http://tool.oschina.net/apidocs/apidoc?api=jdk_7u4

/*异常分类：

JDK中定义了许多异常类，所有异常类都派生于Throwable类的一个实例。
如果内置异常类不能够满足需求，还可以自定义异常类。

1. Throwable
   1.1 Error
       1.1.1 Unchecked Exception
   1.2 Exception
       1.2.1 Checked Exception
       1.2.2 RuntimeException -运行时抛出
             1.2.2.1 Unchecked Exception

RuntimeException(Unchecked Exception):编译器不检查,不捕获
    1. 一类特殊的异常，如被0除，数组下标超出范围等，其产生比较频繁，
       处理麻烦，如果显示的声明或捕获对程序的可读性和运行效率产生影响。
       因此由系统自动检测并将他们交给缺省的异常处理程序（用户不必对其处理）。

Checked Exception:编译器检查
    1. 这类异常，我们必须捕获进行处理
*/
