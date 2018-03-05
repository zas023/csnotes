import java.lang.reflect.*;
import java.io.*;
/**
*反射性能：
*/
public class TestPerformance{

	public static void test1(){
		TestReflection2 test=new TestReflection2();

		long startTime=System.currentTimeMillis();

		for (int i=0;i<1000000000L;i++ ) {
			test.getName();
		}

		long endTime=System.currentTimeMillis();

		System.out.println("普通方法执行十亿次，花费时间："+(endTime-startTime)+" ms");
	}

	public static void test2() throws Exception{
		TestReflection2 test=new TestReflection2();

		Class cl=test.getClass();
		Method m=cl.getDeclaredMethod("getName",new  Class[0]);
		//Method m=cl.getDeclaredMethod("getName",null);  //编译不通过，警告: 最后一个参数使用了不准确的变量类型的 varargs 方法的非 varargs 调用; 


		long startTime=System.currentTimeMillis();

		for (int i=0;i<1000000000L;i++ ) {
			m.invoke(test,new  Object[]{});
		}

		long endTime=System.currentTimeMillis();

		System.out.println("反射动态方法调用执行十亿次，花费时间："+(endTime-startTime)+" ms");
	}

	public static void test3() throws Exception{
		TestReflection2 test=new TestReflection2();

		Class cl=test.getClass();
		Method m=cl.getDeclaredMethod("getName",new Class[0]);

		m.setAccessible(true);

		long startTime=System.currentTimeMillis();

		for (int i=0;i<1000000000L;i++ ) {
			m.invoke(test,new Object[]{});
		}

		long endTime=System.currentTimeMillis();

		System.out.println("反射动态方法调用,跳过安全检查执行十亿次，花费时间："+(endTime-startTime)+" ms");
	}
	
	public static void main(String[] args) throws Exception{
		test1();
		test2();
		test3();

		/*result:
		
		普通方法执行十亿次，花费时间：428 ms
        反射动态方法调用执行十亿次，花费时间：2788 ms
        反射动态方法调用,跳过安全检查执行十亿次，花费时间：1718 ms
		*/
	}
}


/*反射机制性能问题：

1. setAccessible
   - 启动和禁用访问安全的开关、值为true，则表示反射的对象在使用时应该取消Java语言访问检查。
     并不是值为true就能访问而false就不能够访问。

   - 禁止安全检查，提高反射速度。

2. 可以考虑使用：cglib/javaassist字节码操作。
*/

