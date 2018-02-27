/*
*first java program
*/
public class Welcome{
	public static void main(String[] args) {
		System.out.print("Welcome");
		System.out.println("Welcome");//句末换行
		System.out.print("Welcome");
	}
}

//一个Java文件中只有一个public修饰的类

class A{

}

class B{

}

//一个类对应一个class(字节码)文件
//即编译Welcome.java会生成Welcome.class、A.calss、B.calss

//单行注释
/*
  多行注释
  且注释不能嵌套 
*/