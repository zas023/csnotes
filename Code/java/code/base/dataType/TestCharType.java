/*
*字符类型
*/
public class TestCharType{
	public static void main(String[] args) {
		char c1='a';
		char c2='字';
		char c3='\'';  //转义字符

		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c1+c2);
	}
}

/*
1. 字符常量用单引号表示，'A'表示一个字符，"A"表示一个单字符的字符串
2. char类型用来表示在Unicode编码表中的字符
3. Unicode编码被设计来处理各种语言的所有文字，占2个字节，有65536个字符
   Java允许使用转义字符 '\' 来将其后面的字符转变为其他含义
   \n:换行，\b:退格，\r:回车，\t:制表符
4. char可以直接当作整数运算，也可将范围类的整数直接转换为char
*/