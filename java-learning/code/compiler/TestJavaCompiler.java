import javax.tools.*;
import java.io.*;
/**
*JavaCompiler
*/
public class TestJavaCompiler{
	
	public static void main(String[] args) throws IOException{

		//通过IO流操作，将字符串存储成一个临时文件，然后调用动态编译方法
		String source="public class Hi{ public static void main(String[] args){ System.out.println(\"Hi!!!\"); } }";

		// JavaCompiler
		JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
        int result=compiler.run(null,null,null,"HelloWorld.java");
        System.out.println(result==0?"编译成功":"编译失败");

        // Runtime
        Runtime run=Runtime.getRuntime();
        Process process=run.exec("javac -cp HelloWorld.java");

        InputStream in=process.getInputStream();
        BufferedReader reader=new BufferedReader(new InputStreamReader(in));
        String info="";
        while ((info=reader.readLine())!=null) {
        	System.out.println(info);
        }
	}
}

/*动态编译:

1. Java6.0以后引入动态编译机制

2. 应用场景：
   - 可以写一个oj系统，浏览器端写Java代码，上传服务器编译运行
   - 服务器动态加载某些类进行编译

3. 动态编译的两种做法：
   - 通过Runtime调用Javac，启动新的进程去操作
         Runtime run=Runtime.getRuntime();
         Process process=run.exec("javac -cp d:/myJava/ Hello.java");

   - 通过JavaCompiler动态编译
         JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();
         int result=compiler.run(null,null,null,sourceFile);

         run编译方法
         - 第一个参数：为Java编译器提供参数
         - 第二个参数：得到Java编译器的输出信息
         - 第三个参数：接受编译器的错误信息
         - 第三个参数：可变参数（一个String数组）能传入一个或多个Java源文件
         - 返回值：0表示编译成功，非0表示编译失败

*/
