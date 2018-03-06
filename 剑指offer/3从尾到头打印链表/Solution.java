/**
*题目描述：
*输入一个链表，从尾到头打印链表每个节点的值。
*/

import java.util.ArrayList;

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class Solution {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

		ArrayList<Integer> arrayList=new ArrayList<Integer>();

		while(listNode.next!=null){

			System.out.println(listNode.val);

			arrayList.add(listNode.val);

			listNode=listNode.next;
		}

		return arrayList;
	}
}