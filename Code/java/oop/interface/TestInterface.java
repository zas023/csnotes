/**
*interface：接口
*/
public class TestInterface implements MyInterface{

	public void test(){
		System.out.println("TestInterface.test");
	}

	public static void main(String[] args) {

		MyInterface i=new TestInterface();

		i.test();
	}
}

interface A{
	
}

interface B{

}

//接口中只有常量、抽象方法，实现设计与实现的分离

interface MyInterface extends A,B{

	int NUM=100;
	//接口中上面语句等同于下面的语句，编译器添加 public static final
	public static final int NUM1=100;

    void test();
    //接口中，
	//void test() == public static void test()
}

/*接口：

1. 接口 就是比“抽象类”还要抽象的“抽象类”，可以更加规范对子类进行约束。
   全面专业的实现：规范和具体实现的分离

2. 接口就是规范，定义一组规则。

3. 面向接口编程 vs 实现接口编程
   项目的具体需求是多变的，我们必须以不变应万变才能从容开发。

4. 子类通过implements来实现接口中的规范

5. 接口不能创建实例，但可以用于声明引用变量类型

6. 一个类实现了接口，必须实现该接口中的所有方法，且这些方法只能是public

7. 接口支持多继承
*/