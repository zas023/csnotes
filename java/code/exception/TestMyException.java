import java.io.*;
/*
*自定义异常
*/
public class TestMyException{

	public static void main(String[] args) {
		try{
			new TestMyException().test();
		}catch(MyException e){
			e.printStackTrace();
		}
	}

	void test() throws MyException{
		throw new MyException("this is my exception ...");
	}
}


class MyException extends Exception{
	MyException(){
		super();
	}

	MyException(String msg){
		super(msg);
	}
}

/*自定义异常：

1. 在程序中可能会遇到标准异常类中没有充分描述的问题，此时我们可以创建自己的异常类
2. 从Exception类或其子类派生一个子类即可
3. 习惯上异常类应包含2个构造器，一个默认构造器。一个带详细信息的构造器
*/


/*使用异常机制的建议：

1. 要避免使用异常处理代替错误处理，这样会造成程序的清晰性，并且效率低下
2. 处理异常不可代替简单测试————只有在异常情况下使用异常机制
2. 不要进行小粒度的异常处理————应将整个任务包封装在一个try语句块中
4. 异常往往在高层处理

*/