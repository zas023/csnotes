
/**
*abstract：抽象类
*/
public class TestAbstract{
	
	public static void main(String[] args) {
		//Animal a=new Animal();  //错误: Animal是抽象的; 无法实例化

		Animal a=new Cat();
		a.breath();
		//a.voice();
	}
}

abstract class Animal{
	public abstract void voice();

	public void breath(){
		System.out.println("呼吸");
		//voice();
	}
}

class Cat extends Animal{
	public void voice(){
		System.out.println("喵喵喵");
		//breath();
	}
	//错误: Cat不是抽象的, 并且未覆盖Animal中的抽象方法voice()
}
 
/*抽象类：只有声明，没有实现

1. 抽象类是一种模板模式，抽象类为所有子类提供一个通用模板，子类可以拓展
   通过抽象类，我们可以严格的限制子类，使子类之间更加通用

2. 要点：
   - 有抽象方法的类只能定义成抽象类
   - 抽象类不能实例化，即不能用new来实例化抽象类
   - 抽象类可以包含属性、方法、构造器，但只能用来被子类调用
   - 抽象类只能用于继承
   - 抽象方法必须被子类实现
*/