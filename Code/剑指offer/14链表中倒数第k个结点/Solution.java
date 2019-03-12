/**
*题目描述：
*输输入一个链表，输出该链表中倒数第k个结点。
*/

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public ListNode FindKthToTail(ListNode head,int k) {
        if(null==head||k<=0)
            return null;

        ListNode p=head,q=head;

        int i=0;
        while(p!=null){
            //实现倒数向正数转换
            if (i >= k)
                q=q.next;
            p=p.next;
            i++;
        }

        return i<k? null:q;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        ListNode root=new ListNode(1);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(4);

        root.next=node1;
        node1.next=node2;
        node2.next=node3;

        System.out.println(s.FindKthToTail(root,1).val);
    }
}