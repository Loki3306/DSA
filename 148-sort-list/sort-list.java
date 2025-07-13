/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode middle=middleNode(head);
        ListNode left=head;
        ListNode right=middle.next;
        middle.next=null;

        left=sortList(left);
        right=sortList(right);

        return mergeList(left,right);
    }

    public ListNode mergeList(ListNode list1,ListNode list2){
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                temp.next=list1;
                list1=list1.next;
            }
            else{
                temp.next=list2;
                list2=list2.next;
            }

            temp=temp.next;
        }

        if(list1 != null){
            temp.next=list1;
        }
        else{
            temp.next=list2;
        }

        return dummy.next;
    }

    public ListNode middleNode(ListNode head){
        ListNode slowP=head;
        ListNode fastP=head;
        ListNode prev=null;

        while(fastP != null && fastP.next != null){
            prev=slowP;
            slowP=slowP.next;
            fastP=fastP.next.next;
        }

        return prev;
    }
}