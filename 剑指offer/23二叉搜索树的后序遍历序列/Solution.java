/**
*题目描述：
*输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
*如果是则输出Yes,否则输出No。
*假设输入的数组的任意两个数字都互不相同。
*/
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {

    //递归
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }

        return isBST(sequence, 0, sequence.length - 1);
    }


    /**
    * 递归实现检测
    *
    * 对于后序遍历来说，序列数组的最后一个元素一定是根节点,
    * 则根据这个元素，将前面的数组分为左、右两个部分，左侧部分都小，右侧部分都大
    * 如果右侧部分有比该根节点小的元素，那么就不是后序遍历,如此递归进行
    */

    private boolean isBST(int [] array,int start, int end){
        if(start>=end)
            return true;

        //当前子树的根节点
        int curRoot=array[end];
        int splitIndex;
        //找到比curRoot大和比curRoot小的分界点,分成左侧、右侧两组数据
        for(splitIndex = start; splitIndex < end && array[splitIndex] < curRoot;splitIndex ++);
        //只需要看右侧即可，因为前面的for循环，已经确保左侧部分全部都小于curRoot
        for (int i = splitIndex; i < end; i++) {
            if (array[i] < curRoot) {
                return false;
            }
        }
        return isBST(array, start, splitIndex - 1) && isBST(array, splitIndex, end - 1);
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        TreeNode root=new TreeNode(1);
        TreeNode B=new TreeNode(2);
        TreeNode C=new TreeNode(3);
        root.left=B;
        root.right=C;
        TreeNode D=new TreeNode(4);
        TreeNode E=new TreeNode(5);
        TreeNode F=new TreeNode(6);
        B.right=D;
        C.left=F;
        C.right=E;

    }
}