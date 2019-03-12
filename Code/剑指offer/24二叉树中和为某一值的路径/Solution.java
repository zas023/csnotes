/**
*题目描述：
*输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
*路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
*/
import java.util.ArrayList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class Solution {

    private ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {

        if(null==root||target<root.val) return lists;

        list.add(root.val);
        target-=root.val;
        //题目要求路径到叶节点
        if(0==target && null==root.right && null==root.left)
            //一定要重新new一个对象，否则引用会指向同一个结果
            lists.add(new ArrayList(list));
        FindPath(root.left,target);
        FindPath(root.right,target);

        //回退
        list.remove(list.size()-1);
        return lists;
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