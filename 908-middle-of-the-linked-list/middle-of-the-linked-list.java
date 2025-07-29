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
    public ListNode middleNode(ListNode head) {
        ListNode slowP=head;
        ListNode fastP=head;

        while(fastP != null && fastP.next != null){
            slowP=slowP.next;
            fastP=fastP.next.next;
        }

        return slowP;
    }
}