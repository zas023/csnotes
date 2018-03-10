/**
*题目描述：
*把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
*输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 
*例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 
*NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
*/
import java.util.ArrayList;

public class Solution {

	//方法一：遍历
	public static int minNumberInRotateArray(int [] array) {
		if (array.length==0) 
			return 0;
        //遍历，但是最复杂情况时时间复杂的：O(n)
		for (int i=0; i<array.length-1;i++ ) {
			if (array[1]>array[i+1]) 
				return array[i+1];
		}
        //所有元素相等或全部旋转（即没有旋转）
		return array[0];
	}

    //方法二：二分查找,时间复杂度O(logn)
    /*
    (1)array[mid] > array[high]
    出现这种情况的array类似[3,4,5,6,0,1,2]，此时最小数字一定在mid的右边。
    low = mid + 1;
    (2)array[mid] < array[high]
    出现这种情况的array类似[2,2,3,4,5,6,6],此时最小数字一定就是array[mid]或者在mid的左边。
    high = mid;
    (3)array[mid] == array[high]
    出现这种情况的array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字无法判断,只好一个一个试。
    */
	public static int minNumberInRotateArray1(int[] array){
		if (array.length==0) 
			return 0;

		int low = 0;
		int high = array.length-1;

		while(low<high){

			int mid=low+(high-low)/2;

			if (array[mid]>array[high]) {
				low=mid+1;
			}else if(array[mid]==array[high]){
				high--;
			}else{
				high=mid;
			}
		}

		return array[low];

	}


	public static void main(String[] args) {

		int[] array={3,4,5,1,2};
		System.out.println(minNumberInRotateArray(array));
		System.out.println(minNumberInRotateArray1(array));
	}
}