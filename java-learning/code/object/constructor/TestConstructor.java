
/**
*Constructor:构造器
*/
public class TestConstructor{

	public static void main(String[] args) {
		
		//Point p=new Point();  //错误: 无法将类 Point中的构造器 Point应用到给定类型;
		Point p=new Point(3.14,3.14);
	}
}

class Point{

	private double x,y;

	public Point(double x, double y){
		this.x=x;
		this.y=y;
	}
}
/*构造器

1. 构造器又称构造方法，用于构建该类的实例

2. 是一种特殊的方法
   - 通过new关键字调用
   - 构造器虽然有返回值，但不能自定义返回值，返回类型是本类
   - 如果我们没有定义构造器，则系统将会自动定义一个无参构造函数
     如果已经添加构造器，则编译器不会添加
   - 构造器的方法名必须与类名一致
*/