import java.io.*;
/*
*测试Throws
*/
public class TestThrows{

	public static void main(String[] args) {

		String str;
		try{

			str=new TestTryCatch().openFile();

		}catch(FileNotFoundException e){
        	e.printStackTrace();
        	System.out.println("FileNotFoundException!");

		}catch(IOException e){
        	e.printStackTrace();
        	System.out.println("IOException!");
        }

		System.out.println(str);

	}

	
	//通过throw抛出异常，谁调用，谁处理
	String openFile() throws FileNotFoundException,IOException{

		FileReader reader=new FileReader("a.txt");
		int a= reader.read();

		return "step:"+a;
	}
}

/*声明异常：自动抛出，throws子句

1.当Checked Exception产生时，不一定要立刻处理，可以先把异常throws出去
2. 如果一个方法抛出多个已检查异常，就必须在方法的首部列出所有异常，并用逗号隔开。
*/

/*方法重写中声明异常：

1. 子类声明的异常范围不能超出父类声明异常的范围
   1.1 父类没有声明异常，子类也不行
   1.2 不可抛出原有声明异常的父类或者上层类
   1.3 抛出异常类型数不可比原有类型多

*/