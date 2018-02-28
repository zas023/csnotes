import java.util.Date;
/*
*Date时间类
*/
public class TestDate{

	public static void main(String[] args) {
		
		long t=System.currentTimeMillis();
		System.out.println(t);

		Date d1=new Date(1000);
		System.out.println(d1); //默认为北京时区
		d1.setTime(10000);
		System.out.println(d1.getTime());
	}
}

/*Date:java.util.Date

1. 在标准的Java类库中包含一个Date类，它的对象表示特定的一瞬间，精确到毫秒
2. Java的时间说白了就是一个数字，是从标准纪元1970.1.1零时到某一时间的毫秒数，类型为long

*/