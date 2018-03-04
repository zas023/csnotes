import java.lang.reflect.*;
import java.io.*;

/**
*Reflection的作用
*/
public class TestReflection2{

	public String TAG="TestReflection2";

	private String name;

	public static void main(String[] args) {
		try{

			Class cl=Class.forName("TestReflection2");

			System.out.println(cl.getName());
			System.out.println(cl.getSimpleName());

			System.out.println(cl.getFields().length);//只能获取public属性
			System.out.println(cl.getDeclaredFields().length);//获取所有声明的属性

			System.out.println(cl.getDeclaredField("TAG"));

			System.out.println(cl.getDeclaredMethods().length);//获取所有方法
			System.out.println(cl.getDeclaredMethod("main", args.getClass()));//获取方法

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

/*反射机制的作用:

- 动态加载类，动态获取类的信息（属性、方法、构造器）	

- 动态构造对象

- 动态调用类和对象的任意方法、构造器

- 动态调用和处理属性

- 获取泛型信息

- 处理注解

*/
