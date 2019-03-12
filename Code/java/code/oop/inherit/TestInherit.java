
/**
*inherit:继承
*/
public class TestInherit{

	public static void main(String[] args) {
		Mammal m=new Mammal();
		m.run();
		m.pregant();
	}
}

class Animal{
	String eye;

	public void run(){
		System.out.println("run");
	}

	public void eat(){
		System.out.println("eat");
	}
}

class Mammal extends Animal{

	public void run(){
		System.out.println("walk");
	}

	public void pregant(){
		System.out.println("pregant");
	}
}

class Reptile extends Animal{
	
	public void egg(){
		System.out.println("egg");
	}
}

/*继承：

1. 类是对对象的抽象，OOD,继承是对某一批类的抽象，从而实现对现实世界更好的建模

2. 提高代码的复用性，OOP

3. extends：拓展

小结：

1. 子类继承父类，可以得到除父类构造方法以外的全部属性和方法
2. Java中只有单继承，但可以用接口实现多继承
3. 如果一个类没有调用extends，则它的父类是java.lang.Object
*/
