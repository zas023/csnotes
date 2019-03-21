
/**
*override
*/
public class TestOverride{

	public static void main(String[] args) {
		Mammal m=new Mammal();
		m.run();
		m.pregant();
	}
}

/*方法的重写：

1. 子类中可以根据需要对基类中继承的方法进行重写

2. 从写方法和被重写方法具有相同方法名、参数列表和返回类型

3. 重写方法不能使用比被重写方法更严格的访问权限（由于多态）
*/