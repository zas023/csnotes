/**
*题目描述：
*从上往下打印出二叉树的每个节点，同层节点从左至右打印。
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
    //二叉树的层级遍历,用队列实现(广度优先)
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        if(null==root) return null;

        ArrayList<Integer> list = new ArrayList<>();
        //用ArrayList代替队列
        ArrayList<TreeNode> queue = new ArrayList<>();

        queue.add(root);
        while(!queue.isEmpty()){
            //出队
            TreeNode tmp=queue.remove(0);

            //出队元素若有左右孩子，则将左右孩子分别入队
            if(null!=tmp.left)
                queue.add(tmp.left);
            if(null!=tmp.right)
                queue.add(tmp.right);

            list.add(tmp.val);
        }

        return list;
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

        ArrayList<Integer> list=s.PrintFromTopToBottom(root);
        for(Integer i:list)
            System.out.print(i+" ");


    }
}