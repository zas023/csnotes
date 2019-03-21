
/**
*模拟Servlet
*/
public class TestServlet{

	public static void main(String[] args) {
		HttpServlet s=new MyServlet();
		s.service();
		//调用的是父类的service()，子类的doGet();

		//Myservlet实例化过程中，会实例化Object、HttpServlet、MyServlet
		//执行调用时会由下至上查找
		//MyServlet未重写service，即会调用父类HttpServlet中的service

		//但Object、HttpServlet、MyServlet实例化后中的this均是指向MyServlet
		//调用doGet时又从新由下至上开始寻找
	}
}

class MyServlet extends HttpServlet{

	public void doGet(){
		System.out.println("MyServlet.doGet");
	}
}

class HttpServlet{
	
	public void service(){
		System.out.println("HttpServlet.service");
		doGet();
	}

	public void doGet(){
		System.out.println("HttpServlet.doGet");
	}

	public void doPost(){
		System.out.println("HttpServlet.doPost");
	}
}