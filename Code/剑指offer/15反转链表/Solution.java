/**
*题目描述：
*输入一个链表，反转链表后，输出链表的所有元素。
*/

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {

    public ListNode FindKthToTail(ListNode head) {
        if(null==head)
            return null;

        //pre:前一个节点；next:下一个节点；head:当前节点
        ListNode pre=null,next=null;

        //head为当前节点
        while(head!=null){
            next=head.next;
            //修改当前节点的下一个节点为原来链表中的前一个节点
            head.next=pre;

            //设置当前节点为前一个节点
            pre=head;
            //当前节点后移
            head=next;
        }

        return pre;
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

        root=s.FindKthToTail(root);

        while(root!=null){
            System.out.print(root.val);
            root=root.next;
        }
    }
}