/**
*题目描述：
*我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
*请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
*/
public class Solution {

	// 2*n/2*1=n
	//其实就是一个斐波那契数列，满足公式：d(n) = d(n-1) + d(n-2)
    public int RectCover(int target) {
    	if(target<=0)
    		return 0;
    	if(target==1)
    		return 1;
    	if(target==2)
    		return 2;

    	int first=1, second=2, third=0;
    	for (int i=3;i<=target ;i++ ) {
    		third=first+second;
    		first=second;
    		second=third;
    	}
    	return third;

    }

    public static void main(String[] args) {
    	Solution s=new Solution();
    	System.out.println(s.RectCover(10));
    }
}

/*
逆向分析
应为可以横着放或竖着放，
多以f(n)可以是2*(n-1)的矩形加一个竖着放的2*1的矩形
或2*(n-2)的矩形加2横着放的，即f(n)=f(n-1)+f(n-2)
当到了最后，f(1)=1,f(2)=2
*/