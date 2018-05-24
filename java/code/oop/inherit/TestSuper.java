/**
*super：类似this
*/

public class TestSuper{

	public static void main(String[] args) {
		
	}
}

/*super:

1. super是直接父类对象的引用，可以通过super来访问父类中被子类覆盖的方法或属性

2. 普通方法：没有顺序限制，可以随便调用
   构造方法：任何类的构造函数中，若是构造函数第一行没有显式的调用super(..),那么
            Java默认都会调用super()作为父类的初始化函数。

*/