
/**
*polymorphism：多态
*/
public class TestPolymorphism{

    //不使用多态
	public static void testCat(Cat a){
		a.voice();
	}

	public static void testDog(Dog a){
		a.voice();
	}

	public static void testPig(Pig a){
		a.voice();
	}

	//使用多态
	public static void testAnimal(Animal a){
		a.voice();
	}
	
	public static void main(String[] args) {
		
		testCat(new Cat());

		testAnimal(new Cat());  //父类的引用指向一个子类对象
		testAnimal(new Dog());
	}
}

class Animal{

	String str;

	public void voice(){
		System.out.println("普通动物叫声");
	}
}

class Cat extends Animal{

	public void voice(){
		System.out.println("喵喵喵");
	}
}

class Dog extends Animal{

	public void voice(){
		System.out.println("汪汪汪");
	}
}

class Pig extends Animal{

	public void voice(){
		System.out.println("哼哼哼");
	}
}

/*多态

1. 多态是OOP中的一个重要的特征，主要实现动态联编的，换句话说，
   就是程序的最终状态只有在执行过程中才被决定而非在编译期间。

2. Java如何实现多态
   引用变量的两种类型：
   - 编译时类型（模糊点，一般是一个父类）
         - 由声明时的类型决定
   - 执行时类型（运行时，具体是哪个子类就是那个子类）
         - 由实际对象的类型决定

3. 多态的三个必要条件
   - 要有继承、要有方法重写、父类引用指向子类对象
*/