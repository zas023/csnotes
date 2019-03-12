/**
*题目描述：
*大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
*n<=39
*/
import java.util.ArrayList;

public class Solution {

	//方法一：循环
	public int Fibonacci(int n) {
		int preNum=1;
		int prePreNum=0;
		int result=0;
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		for(int i=2;i<=n;i++){
			result=preNum+prePreNum;
			prePreNum=preNum;
			preNum=result;
		}
		return result;
	}

	//方法二：递归
	public int Fibonacci1(int n) {

		return Fibonacci1(n,0,1);
	}

	public int Fibonacci1(int n,int acc1,int acc2){
		if(n==0)
			return 0;
		if(n==1)
			return acc2;
		else
			return Fibonacci1(n - 1, acc2, acc1 + acc2);
	}

	//尽量不用递归，如果数很大时，会很耗时
	public static void main(String[] args) {

		Solution s=new Solution();
		System.out.println(s.Fibonacci(35));
		System.out.println(s.Fibonacci1(35));
	}
}

/*
Fibonacci(4) = Fibonacci(3) + Fibonacci(2);
             = Fibonacci(2) + Fibonacci(1) + Fibonacci(1) + Fibonacci(0);
             = Fibonacci(1) + Fibonacci(0) + Fibonacci(1) + Fibonacci(1) + Fibonacci(0);
*/