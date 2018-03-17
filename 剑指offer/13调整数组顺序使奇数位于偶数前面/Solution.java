/**
*题目描述：
*输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
*所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
*/
public class Solution {

    public void reOrderArray(int [] array) {

        if(array==null||array.length<2)
            return;

        for (int i=0;i<array.length ;i++ ) {
            if (0==array[i]%2) {
                for (int j=i+1;j<array.length ; j++) {
                    if (0!=array[j]%2) {
                        int temp=array[j];
                        for (int j2 = j-1; j2 >=i; j2--) {
                            array[j2+1] = array[j2];
                        }
                        array[i++] = temp;
                    }
                }
            }
        }

        for (int i=0;i<array.length ;i++ ) {
            System.out.print(array[i]);
        }
    }

    public static void main(String[] args) {

        int[] array={1,2,3,4,5,6,7};   //[1,3,5,7,2,4,6]

        Solution s=new Solution();
        s.reOrderArray(array);
    }
}
/**
 * 1.要想保证原有次序，则只能顺次移动或相邻交换。
 * 2.i从左向右遍历，找到第一个偶数。
 * 3.j从i+1开始向后找，直到找到第一个奇数。
 * 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
 * 5.終止條件：j向後遍歷查找失敗。
 */