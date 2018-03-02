
/**
*Object vs Class：对象和类的概念
*/
public class TestClass{

	public static void main(String[] args) {

		//通过加载器 Class Loader加载Student类，将类的信息存放在方法区
		Student stu=new Student();
		stu.name="anshun";
		stu.age=20;

		//"anshun"、20均是常量，存放到方法区中的常量池
		//而堆中对象的属性则存放对应的地址

		String str="anshun";
		System.out.println(str==stu.name);
		//结果为true，即str与name指向同一个内存地址
	}
}

class Student{
	String name;
	int age;
}
/*

1. 面向对象编程(OOP)的本质：
   - 以类的方式组织代码，以对象的方式组织数据。

2. 面向对象思维：OOA,OOD

3. 对象：是具体的事物
   类：  是对对象的抽象（抽象abstract：抽出象的部分）

4. 先有具体的对象，然后抽象各个对象之间象(相似)的部分，
   归纳出类，通过类再认识其他对象

*/

/*类的属性

1. 属性：field，或者叫做成员变量
2. 属性用于定义该类或改对象包含的数据或者说静态属性
3. 属性的作用范围是整个类体
4. 在定义成员变量时可以对其初始化，如果不对其初始化，Java使用默认值初始化
   （数值：0，0.0  char:\u0000  bollen:false  引用类型：null)

*/

/*类的方法

1. 面向对象中，整个程序的基本单位时类，方法是属于类的
2. Java中的方法参数传递是：值传递

*/

//变量的作用域 

/*内存分析

1. 栈stack：存放局部变量
   堆heap：存放new出来的对象
   方法区method，也称静态存储区：存放类的信息(代码)、static变量、
          常量池(存放基本类型常量和字符串常量)等

   栈：自动分配连续的空间，后进先出
   堆：不连续

   //方法区也是堆，存放在堆中
 

*/