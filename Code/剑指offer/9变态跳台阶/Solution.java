/**
*题目描述：
*一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
*求该青蛙跳上一个n级的台阶总共有多少种跳法。
*/
public class Solution {

    public int JumpFloor(int target) {
    	return  1<<--target;
    }

    public static void main(String[] args) {
    	Solution s=new Solution();
    	System.out.println(s.JumpFloor(10));
    }
}

/*
每个台阶都有跳与不跳两种情况（除了最后一个台阶），最后一个台阶必须跳。
所以共用2^(n-1)中情况，这里的一行就是通过位移做乘法得到2^(n-1)的结果。
*/