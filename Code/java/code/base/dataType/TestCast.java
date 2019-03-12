/*
*类型转换
*/
public class TestCast{
	public static void main(String[] args) {
		//自动转型
		long l=1234;
		float f=l;

		//强制转型
		int i1=100;
		char c1=(char) i1;
		System.out.println(c1);

		//表达式中的类型提升问题
		int i2=1;
		long l2=2;
		//i2=i2+l2; //所有二元运算(+-*%),会向容量大的类型提升
		l2=i2+l2;
		i2=(int) (i2+l2);

		//当数值较大时，检查是否溢出
		int money=1000000000;
		int year=10;
		int total=money*year;
		long total1=money*year;  //int*int，结果还是int,即赋值前计算结果溢出，将错误的结果自动转换为long型
		long total2=(long) money*year;  //先转型，后计算，将money转换成long
		System.out.println(total);

		//尽量将类型转换放前面，避免前面运算溢出
		long l3=60*60*24*365*70L;
		long l4=60L*60*24*365*70; 

	}
}

/*转型：
1. 自动类型转换
   1.1 容量小的数据类型可以自动转换为容量大的数据类型
   1.2 整型可以直接赋值给小容量数据类型，如byte、char、short,只要不超出其表示范围

2. 强制类型转换
   2.1 又称造型，用于显示的转换一个数值的类型
       在有可能丢失信息的情况下进行的类型转换是通过造型完成的，但可能造成精度降低或溢出
   2.2 当类型超出目标类型的范围，则会被截断成完全不同的值
*/