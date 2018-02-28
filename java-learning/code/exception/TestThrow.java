import java.io.*;
/*
*测试Throw
*/
public class TestThrow{

	public static void main(String[] args) {

		File f=new File("d.txt");
		if (!f.exists()) {
			try{
				throw new FileNotFoundException("File not found!!!");
			}catch(FileNotFoundException e){
        	    e.printStackTrace();
            }
		}

	}


}

/*声明异常：手动抛出，throws子句

1. Java异常类对象除了在执行过程中由系统自动生成并抛出以外，还可以根据需要手动创建并抛出
2. 在捕获异常前，必须有一段代码先产生异常并把它抛出，这个过程可以自己完成，也可是JRE实现，但他们均调用throw子句
3. 对一个已存在的异常类，抛出过程如下：
   3.1 找到一个合适的异常类
   3.2 创建一个该类的对象
   3.3 将异常抛出
*/

/*方法重写中声明异常：

1. 子类声明的异常范围不能超出父类声明异常的范围
   1.1 父类没有声明异常，子类也不行
   1.2 不可抛出原有声明异常的父类或者上层类
   1.3 抛出异常类型数不可比原有类型多

*/