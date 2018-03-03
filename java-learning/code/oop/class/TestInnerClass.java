/**
*innerclass:内部类
*/
public class TestInnerClass{
	
	public static void main(String[] args) {

		Face f=new Face();

		Face.Nose n=f.new Nose();//非静态内部类，内部类从属于外部类对象

		n.breath();

		Face.Ear e=new Face.Ear();//静态内部类

		e.listen();
	}
}

class Face{
	int type=10;

	static String color="RED";

	class Nose{

		String name;

		int type=20;

		void breath(){
			System.out.println(Face.this.type); //解决冲突
			System.out.println(type);  
		}
	}

	static class Ear{

		void listen(){
			System.out.println(color);
		}
	}
}

/*内部类：

1. 作用
   - 内部类提供更好的封装，只允许外部类直接访问，不允许同一包中其他类直接访问
   - 内部类可以直接访问外部类的私有属性，内部类当作外部类的成员。
     但外部类不能直接访问内部类的内部属性

2. 内部类分类
   - 成员内部类:普通内部类（可以用控制符修饰，类文件：外部类$内部类.class)
     - 非静态内部类，此时内部类从属于外部类对象
     - 静态内部类，内部类从属于外部类
   
   - 匿名内部类
     适合那种只需要使用一次的类。如键盘监听操作等

   - 局部内部类
     定义在方法内部

*/