import java.lang.reflect.*;
import java.io.*;

/**
*Reflection的作用
*/
public class TestReflection2{

	public String TAG="TestReflection2";

	private String name;

	public TestReflection2(){

	}

	public TestReflection2(String name){
		this.name=name;
	}

	public String getName(){
		return name;
	}

	public void print(String str){
		if (str==null) 
			System.out.println(name);
		else
			System.out.println(str);
	}

	public static void main(String[] args) {
		try{

			Class cl=Class.forName("TestReflection2");

			System.out.println(cl.getName());
			System.out.println(cl.getSimpleName());

			//获取属性
			System.out.println(cl.getFields().length);//只能获取public属性
			System.out.println(cl.getDeclaredFields().length);//获取所有声明的属性

			System.out.println(cl.getDeclaredField("TAG"));

			//获取参数
			System.out.println(cl.getDeclaredMethods().length);//获取所有方法
			System.out.println(cl.getDeclaredMethod("main", args.getClass()));//获取方法

			//获取构造器
			Constructor[] constructors=cl.getConstructors();

			//通过反射API，动态构造对象

			  //默认构造器
			TestReflection2 test=(TestReflection2) cl.newInstance();  //无参构造器
			System.out.println(test);
              //选择构造器
			Constructor c=cl.getDeclaredConstructor(String.class);
			TestReflection2 test2=(TestReflection2) c.newInstance("name");
			System.out.println(test2);

			//通过反射API，动态调用方法
			Method m =cl.getDeclaredMethod("print",String.class);
			m.invoke(test2,"null");

			//通过反射API，动态操作属性
			Field f=cl.getDeclaredField("name");
			f.setAccessible(true);  //设置访问私有属性（不进行安全检查）
			f.set(test,"name");


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
