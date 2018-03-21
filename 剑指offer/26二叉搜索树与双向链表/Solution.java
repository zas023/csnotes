/**
*题目描述：
*输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
*要求不能创建任何新的结点，只能调整树中结点指针的指向。
*/
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
/*解题思路：
1.将左子树构造成双链表，并返回链表头节点。
2.定位至左子树双链表最后一个节点。
3.如果左子树链表不为空的话，将当前root追加到左子树链表。
4.将右子树构造成双链表，并返回链表头节点。
5.如果右子树链表不为空的话，将该链表追加到root节点之后。
6.根据左子树链表是否为空确定返回的节点。
*/
public class Solution {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(null==pRootOfTree) return null;
       
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p=left;

        // 2.定位至左子树双链表最后一个节点
        while(null!=p&&null!=p.right){
            p=p.right;
        }

        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(left!=null){
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }

        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(pRootOfTree.right);

        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }

        // 6.根据左子树链表是否为空确定返回的节点。
        return left==null? pRootOfTree:left;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
    }
}