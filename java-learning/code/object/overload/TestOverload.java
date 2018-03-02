
/**
*overload:重载
*/
public class TestOverload{

	public int add(int a, int b){
		return a+b;
	}

	public static void main(String[] args) {
		MyMath math=new MyMath();

		System.out.println(math.add(4,5));

		System.out.println(math.add(4,5.5));
	}
}

class MyMath{

	public int add(int a, int b){
		return a+b;
	}

	public int add(double a, int b){
		return (int)(a+b);
	}

	public int add(int a, double b){
		return (int)(a+b);
	}

	public int add(int a, int b,int c){
		return a+b+c;
	}
}

/*重载：

1. 方法的重载是指一个类中可以定义有相同的名字，但参数不同的多个方法。
   调用时，会根据不同的参数表选择对应的方法

2. 两同三不同
   - 同一类，同一个方法名
   - 参数表不同（类型、个数、顺序）

3. 和普通方法一样，构造函数也可以重载

*/