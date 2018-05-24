import java.text.*;
import java.util.Date;
/*
*格式转换
*/
public class TestSimpleFormat{

	public static void main(String[] args) {

		DateFormat df=new SimpleDateFormat("yyyy年MM月dd日");  //DateFormat是抽象类，只能创建其子类(实现类)对象

		//foramt
		Date d=new Date(123456789);
		String str=df.format(d);
		System.out.println(str);

		//parse
		str="2018年02月28日";
		try{
			d=df.parse(str);
		}catch(ParseException e){
			e.printStackTrace();
		}
		System.out.println(d);

	}
	
}

/*完成字符串和时间的转换
1. format

2. parse

字母	日期或时间元素	表示	示例
G	Era 标志符	Text	AD
y	年	Year	1996; 96
M	年中的月份	Month	July; Jul; 07
w	年中的周数	Number	27
W	月份中的周数	Number	2
D	年中的天数	Number	189
d	月份中的天数	Number	10
F	月份中的星期	Number	2
E	星期中的天数	Text	Tuesday; Tue
a	Am/pm 标记	Text	PM
H	一天中的小时数（0-23）	Number	0
k	一天中的小时数（1-24）	Number	24
K	am/pm 中的小时数（0-11）	Number	0
h	am/pm 中的小时数（1-12）	Number	12
m	小时中的分钟数	Number	30
s	分钟中的秒数	Number	55
S	毫秒数	Number	978
z	时区	General time zone	Pacific Standard Time; PST; GMT-08:00
Z	时区	RFC 822 time zone	-0800

注意大小写
*/