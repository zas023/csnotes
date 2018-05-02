/**
*统计一个数字在排序数组中出现的次数。
*/

public class Solution {

    public int GetNumberOfK(int [] array , int k) {
        if (array.length==0)
            return 0;
        if (array.length==1){
            if(array[0]!=k)
                return 0;
            else {
                return 1;
            }
        }
        return Method(array,0,array.length-1,k);
    }

    private int Method(int []array,int low,int high,int k){
        if(high==low){
            if(array[low]!=k)
                return 0;
            else {
                return 1;
            }
        }
        int mid=(high+low)/2;
        if (array[mid]>k)
            return Method(array,low,mid,k);
        if (array[mid]<k)
            return Method(array,mid+1,high,k);
        return Method(array,low,mid,k)+Method(array,mid+1,high,k);
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println();
    }
}