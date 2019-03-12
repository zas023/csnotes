/*
*测试Scanner类
*/
import java.util.Scanner;

public class TestScanner{
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		String str=s.next();
		System.out.println("刚才输入："+str);
	}
}