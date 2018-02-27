import java.io.*;
/*
*测试异常处理
*/
public class TestTryCatch{

	public static void main(String[] args) {

		System.out.println(new TestTryCatch().openFile());

	}

	/*执行顺序：
	1. 执行try,catch，给返回值赋值
	2. 执行 finally
	3. return
	*/

	String openFile(){
		try{

			System.out.println("aaa");
			
			FileReader reader=new FileReader("a.txt");
			int a= reader.read();
			System.out.println(a);

			System.out.println("bbb");

			return "step1";
        }catch(FileNotFoundException e){
        	System.out.println("catching!!!");
        	e.printStackTrace();
        	System.out.println("FileNotFoundException!");

        	return "step2";
        }catch(IOException e){
        	e.printStackTrace();
        	System.out.println("IOException!");

        	return "step3";
        }finally{
        	System.out.println("finally！！！");

        	return "fff";
        }
	}
}

/*异常处理：
1. 捕获异常（try,catch,finally)
   try执行过程中，遇到异常，进入catch；未遇异常，进入finally。

   1.1 try语句指定了一段代码，该段代码就是一次捕获并处理的范围。
       在执行过程中，当任意一条语句产生异常时，就会跳过该段中后面的代码。
       代码中可能会产生并抛出一种或多种类型的异常对象，它后面的catch语句要分别对这些异常进行相应处理。

       一个try语句必须带有至少一个catch语句块或一个finally语句块。

       注：当异常处理的代码执行结束后，是不会会带try语句去执行接下来的代码。
    
    1.2 catch常用方法：
            toString() 显示异常的类名和产生异常的原因
            getMessage() 只显示产生异常的原因，不现实类名
            printStackTrace() 用来跟踪异常发生时堆栈的内容

        这些方法均继承自 Throwable类

        catch捕获异常的顺序：
            如果异常之间有继承关系，在顺序安排上需要注意，越是顶层的类，越放在下面。
            再不然就直接把多余的catch省略掉。

    1.3 finally:
        有些语句，不论是否发生异常，都必须执行，那么就可以吧这类语句放入finally块中。
        通常在finally中 关闭程序块已打开的资源。
*/