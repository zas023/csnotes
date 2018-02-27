/*
*数据类型
*/
public class TestDataType{

	public static void main(String[] args) {
		int a1=10;  //默认十进制int类型，4字节
		int a2=015;
		int a3=0x15;

		//如果数据大小没有超过byte、short、char范围，则自动转型
		//否则报错
		//byte b=200;
		byte b2=100;

		long c1=55555555;
		long c2=55555555555555555L;
		//long c2=55555555555555555;//报错，已经超过int表示的范围

		System.out.println(c1);

        System.out.println(Integer.toBinaryString(a1));  //二进制
		System.out.println(Integer.toOctalString(a1));  //八进制
		System.out.println(Integer.toHexString(a1));  //十六进制
	}
}

//Java是一种强类型语言，每一个变量都必须声明其数据类型

/*Java数据类型：

1. 基本数据类型
   1.1 数值类型
       1.1.1 整数类型 (byte-1字节、short-2字节、int-4字节、long-8字节)
       1.1.2 浮点类型 (float-4字节、double-8字节)
   1.2 字符型 (char)
   1.3 布尔型 (boolen)

2. 引用数据类型
   2.1 类 (class)
   2.2 接口 (interface)
   2.3 数组

*/

/*整型常用表示：
1. 十进制，如99、-99，0
2. 八进制，需要以0开头，如015
3. 十六进制，需要以0x开头，如0x15

*声明long型常量可以加"l"或"L"
*/
