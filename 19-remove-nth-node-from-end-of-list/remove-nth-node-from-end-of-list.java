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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null ) return null;
        if(head.next == null && n==1) return null;
        if(head.next == null) return head;

        if(n==1){
            ListNode temp=head;
            while(temp.next.next != null){
                temp=temp.next;
            }
            temp.next=null;
            return head;
        }

        int cnt=0;
        ListNode temp=head;
        while(temp!=null){
            cnt++;
            temp=temp.next;
        } 

        if( cnt == n){
            return head.next;
        }

        int cnt1=0;
        temp=head;
        while(temp!=null){
            cnt1++;
            if(cnt1 ==  cnt-n){
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }

        return head;
    }
}