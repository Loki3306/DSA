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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minh = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(int i=0;i<lists.length;i++){
            ListNode curr = lists[i];
            while(curr != null){
                minh.add(curr);
                curr = curr.next;
            }
        }

        ListNode ans = new ListNode(-1);
        ListNode temp = ans;

        while(temp != null){
            temp.next = minh.poll();
            temp = temp.next;
        }

        return ans.next;
    }
}