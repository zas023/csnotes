/**
*题目描述：
*输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
*假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
*例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
*/

//Definition for binary tree
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {

	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		
		return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);

	}

    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
	public TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

		if(startPre>endPre||startIn>endIn)
			return null;

		TreeNode root=new TreeNode(pre[startPre]);

		//递归寻找左右子树
		for(int i=startIn;i<=endIn;i++){
			if(in[i]==pre[startPre]){
				root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
				root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
				break;
			}
		}

		return root;
	}

	//第一名：
	public TreeNode reConstructBinaryTree2(int [] pre,int [] in) {
		if(pre==null||in==null){
			return null;
		}

		java.util.HashMap<Integer,Integer> map= new java.util.HashMap<Integer, Integer>();
		for(int i=0;i<in.length;i++){
			map.put(in[i],i);
		}
		return preIn(pre,0,pre.length-1,in,0,in.length-1,map);
	}

	public TreeNode preIn(int[] p,int pi,int pj,int[] n,int ni,int nj,java.util.HashMap<Integer,Integer> map){

		if(pi>pj){
			return null;
		}
		TreeNode head=new TreeNode(p[pi]);
		int index=map.get(p[pi]);
		head.left=preIn(p,pi+1,pi+index-ni,n,ni,index-1,map);
		head.right=preIn(p,pi+index-ni+1,pj,n,index+1,nj,map);
		return head;
	}
}

/*
前序第一个定位根节点
再找到中序中此根节点的位置，左面的为左孩子，右边为有孩子

int [] pre,int startPre,int endPre三个参数代表一段子序列
*/