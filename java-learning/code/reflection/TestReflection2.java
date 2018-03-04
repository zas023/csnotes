import java.lang.reflect.*;
import java.io.*;

/**
*Reflection的作用
*/
public class TestReflection2{

	public static void main(String[] args) {
		try{

			Class cl=Class.forName("TestReflection2");

			System.out.println(cl);

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
