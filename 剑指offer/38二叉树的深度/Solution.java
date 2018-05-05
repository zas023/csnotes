/**
*输入一棵二叉树，求该树的深度。
*从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
*最长路径的长度为树的深度。
*/
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    //递归
    public int TreeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return Math.max(left, right) + 1;
    }

    //非递归
    public int TreeDepth2(TreeNode root){
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth = 0, count = 0, nextCount = 1;
        while(queue.size()!=0){
            TreeNode top = queue.poll();
            count++;
            if(top.left != null){
                queue.add(top.left);
            }
            if(top.right != null){
                queue.add(top.right);
            }
            if(count == nextCount){
                nextCount = queue.size();
                count = 0;
                depth++;
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}