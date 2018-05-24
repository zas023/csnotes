
/**
*This:隐式参数
*/
public class TestThis{

	public static void main(String[] args) {
		Student stu=new Student("anshun");
	}
}

class Student{
	String name;
	int id;

	public Student(){

	}

	public Student(String name){
		this();  //通过this调用其它方法
		this.name=name;
		//this();  //错误: 对this的调用必须是构造器中的第一个语句
	}

	public void study(/*Student this*/){   //传递隐式的参数this
		this.name="anshun";
		System.out.println(name+"学习");
	}

}
/*this

1. 普通方法中：this总是指向调用该方法的对象

2. 构造方法中：this总是指向正要初始化的对象

3. this不能用于static方法（static方法不传递this参数）
*/

//隐式参数的含义：普通方法中默认传入一个参数，即this

//类初始化存储于方法区，所有该类对象共用这一份代码，调用时传入this，以确定哪个对象