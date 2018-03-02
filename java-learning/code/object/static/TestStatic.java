
/**
*Static
*/

public class TestStatic{

	public static void main(String[] args) {
		Car.brand="bmw";
		Car.printBrand();

		Car c1=new Car();

		c1.brand="audi";
		c1.printBrand();

		Car c2=new Car();
		c2.printBrand();

	}
}

class Car{

	public static String brand;

	public static void printBrand(){
		System.out.println(brand);
	}
}

/*Static:区分类的变量和对象的变量

1. 在类中，用static声明的成员变量称之为静态成员变量，或类属性、类变量
   - 它为该类的公共变量，属于类，被类的所有实例共享，在类被载入时被显示初始化
   - 对该类的所有对象来说，static成员变量只有一份，被该类所有对象共享
   - static变量存储于方法区中

2. 用static声明的方法称作静态方法
   - 不需要对象就可以直接调用
   - 在调用该方法时，不会将对象的引用传递给它，所以在static方法中不可访问非static的成员，
     而非static的成员可以访问和调用static成员。

//static对象从属于类，创建对象时不会存储static成员
*/

/*静态初始化块

1. 如果希望加载后，对整个类进行某些初始化操作，可以使用static初始化块

2. 是类初始化时执行，不是创建对象时

3. 静态初始化块不能访问非static成员

4. 执行顺序：
   - 上溯到Object类，先执行Object的静态初始化块，再向下执行子类的静态初始化块。

*/

