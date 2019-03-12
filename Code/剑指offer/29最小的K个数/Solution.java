/**
*题目描述：
*输入n个整数，找出其中最小的K个数。
*例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
*/
import java.util.ArrayList;

public class Solution {

    /*思路一：O(N)
    利用快速排序中的获取分割（中轴）点位置函数getPartitiion。
    基于数组的第k个数字来调整，使得比第k个数字小的所有数字都位于数组的左边，
    比第k个数字大的所有数字都位于数组的右边。
    调整之后，位于数组左边的k个数字就是最小的k个数字（这k个数字不一定是排序的）。
    */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList list = new ArrayList();
        if(input.length == 0 || k > input.length || k <= 0)
            return list;
        int low = 0;
        int high = input.length-1;
        int index = Partition(input,k,low,high);
        while(index != k-1){
            if (index > k-1) 
                index = Partition(input,k,low,index-1);
            else
                index = Partition(input,k,index+1,high);
        }
        for (int i = 0; i < k; i++)
            list.add(input[i]);
        return list;
    }

    int Partition(int[] input,int k,int low,int high){
        //选取轴值
        int pivotkey = input[k-1];
        //将轴值置于数组第一位
        swap(input,low,k-1);
        while(low < high){
            //由高至低，找到比轴值小的数，且于轴值交换
            while(low < high && input[high] >= pivotkey)
                high--;
            swap(input,low,high);
            //由低至高，找到比轴值大的数，且于轴值交换
            while(low < high && input[low] <= pivotkey)
                low++;
            swap(input,low,high);
        }
        return low;
    }

    private void swap(int[] input, int low, int high) {
        int temp = input[high];
        input[high] = input[low];
        input[low] = temp;
    }

    /*思路二：
    利用堆排序，O(N logK)，适合处理海量数据
    (1) 遍历输入数组，将前k个数插入到推中；
    (2) 继续从输入数组中读入元素做为待插入整数，并将它与堆中最大值比较：
    如果待插入的值比当前已有的最大值小，则用这个数替换当前已有的最大值；
    如果待插入的值比当前已有的最大值还大，则抛弃这个数，继续读下一个数。
    这样动态维护堆中这k个数，以保证它只储存输入数组中的前k个最小的数，最后输出堆即可。
    */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(input==null||input.length==0||input.length<k)
            return result;
        //构建大顶堆
        for(int i=k/2-1;i>=0;i--){
            adjustHeap(input,i,k-1);
        }
        //我们前k个元素的大顶堆已经构建好了，剩下的就是其余的和大顶堆的最大值比较了
        for(int i=k;i<input.length;i++){
            if(input[i]<input[0]){
                int temp=input[i];
                input[i]=input[0];
                input[0]=temp;
                adjustHeap(input,0,k-1);
            }
        }
        //我们将调整好的前k个数放进链表里面
        for(int i=0;i<k;i++){
            result.add(input[i]);
        }
        return result;
    }

    //构建大顶堆
    public void adjustHeap(int[] input,int i,int k){
        //先把最上面根节点保存了
        int temp=input[i];
        for(int j=i*2+1;j<=k;j=j*2+1){
            //j可以等于k，但是下面的程序不能，我们还要判断j和j+1呢
            if(j<k&&input[j]<input[j+1]){
                j++;
            }
            if(temp>input[j]){
                break;
            }
            input[i]=input[j];
            i=j;
        }
        input[i]=temp;
    }

    public static void main(String[] args) {

        Solution s=new Solution();

        int[] array={4,5,1,6,2,7,3,8};

        System.out.println(s.GetLeastNumbers_Solution(array,4).toString());
        System.out.println(s.GetLeastNumbers_Solution2(array,4).toString());
    }
}