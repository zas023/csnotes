/**
*题目描述：
*输入两个单调递增的链表，输出两个链表合成后的链表，
*当然我们需要合成后的链表满足单调不减规则。
*/

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    //递归(类似于归并排序算法)
    public ListNode Merge(ListNode list1,ListNode list2) {

        if(null==list1)
            return list2;
        if(null==list2)
            return list1;

        if (list1.val<list2.val) {
            list1.next=Merge(list1.next,list2);
            return list1;
        }else{
            list2.next=Merge(list1,list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        ListNode root=new ListNode(1);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(4);

        root.next=node1;
        node2.next=node3;

        root=s.Merge(root,node2);

        while(root!=null){
            System.out.print(root.val);
            root=root.next;
        }
    }
}