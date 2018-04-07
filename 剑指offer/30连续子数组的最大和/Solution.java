/**
*题目描述：
*HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
*今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
*当向量全为正数的时候,问题很好解决。
*但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
*例如:{6,-3,-2,7,-15,1,2,2},
*连续子向量的最大和为8(从第0个开始,到第3个为止)。
*你会不会被他忽悠住？(子向量的长度至少是1)
*/
import java.util.*;

public class Solution {

    //动态规划
    public int FindGreatestSumOfSubArray(int[] array) {
        int result=array[0];  //上次记录的最大值
        int tmp=array[0];    //本次记录的最大值
        for (int i=1;i<array.length;i++ ) {
            tmp=Math.max(tmp+array[i],array[i]);
            result=Math.max(tmp,result);
        }
        return result;
    }

    public static void main(String[] args) {

        Solution s=new Solution();

        int[] array={6,-3,-2,7,-15,1,2,2};

        System.out.println(s.FindGreatestSumOfSubArray(array));
    }
}
