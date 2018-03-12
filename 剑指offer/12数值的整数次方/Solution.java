/**
*题目描述：
*给定一个double类型的浮点数base和int类型的整数exponent。
*求base的exponent次方。
*/
import java.util.*;
public class Solution {

    //递归
	public double Power(double base, int exponent) {

        int exp=Math.abs(exponent);

        if(exp==0)
            return 1.0;
        if (exp==1) 
            return base;

        double result = 0.0;
        result=Power(base,exp>>1);
        result*=result;

        if((exp&1)==1)    // 如果指数n为奇数，则要再乘一次底数base
            result *=base;

        if(exponent<0)    // 如果指数为负数，则应该求result的倒数
            result=1/result;

        return result;
    }

    public static void main(String[] args) {
    	Solution s=new Solution();
    	System.out.println(s.Power(3,3));
    }
}

/*
第一种方法：使用递归，时间复杂度O(logn)
当n为偶数，a^n =（a^n/2）*（a^n/2）
当n为奇数，a^n = a^[(n-1)/2] * a^[(n-1)/2] * a
举例：
2^11 = 2^1 * 2^2 * 2^8
2^1011 = 2^0001 * 2^0010 * 2^1000

第二种方法：累乘，时间复杂度为O(n)

*/
