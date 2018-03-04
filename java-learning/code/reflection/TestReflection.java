import java.lang.reflect.*;
import java.io.*;
/**
*Reflection：反射机制
*/
public class TestReflection{

	public static void main(String[] args) {
		try{

			Class cl=Class.forName("TestReflection");

			System.out.println(cl);

			Class cl2=Class.forName("TestReflection");
			//一个类只有一个Class对象:
			System.out.println(cl.hashCode()==cl2.hashCode());

			String str="anshun";

			//另外两种获取Class对象的方法
			Class strClass=str.getClass();
			Class strClass2=String.class;

			System.out.println(strClass==strClass2);

			//注意数组的维度和类型不同，则对应Class的对象不同
			int[] array=new int[10];
			int[][] array2=new int[10][10];
			double[] array3=new double[10];

			System.out.println(
				array.getClass().hashCode()==array2.getClass().hashCode()); //结果：false

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

/*动态语言:

1. 程序运行时，依然可以改变程序的结构或变量类型
   - Python、Rubly、JavaScript等，如js中 var=3；

2. C、C++、Java不是动态语言，但是Java有一定的动态，
   我们可以利用反射机制、字节码操作获取到类似动态语言的特性。

*/

/*反射机制：

1. 指的是可以于运行时加载、探知、使用便宜期间完全未知的类

2. 程序运行中，可以动态加载一个只有类名的类，对于任意一个已经加载的类，
   都能够知道这个类的所有属性和方法；对于任意一个对象，都能调用它的任意属性和方法；

   Class class=Class.forName("TestReflectiom");

3. 加载完类之后，在堆的内存中，就产生一个Class类型的对象（一个类只有一个Class对象），
   如上面的 class ,这个对象就包含完整的类的结果信息。

   我们通过这个对象看到类的结构，这个对象类似一面镜子，透过这个镜子看到类的结构，所有形象称之为：反射
*/

/*如何获取Class类的对象：

- 运行getClass();
- 运行Class.forName();
- 运用.class语法

*/