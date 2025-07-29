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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1=length(l1);
        int len2=length(l2);

        if(len1 > len2){
            ListNode temp1=l1;
            ListNode temp2=l2;  
            int carry=0;
            ListNode prev=null;

            while(temp2 != null){
                int sum=temp1.val+temp2.val+carry;
                temp1.val=sum%10;
                carry=sum/10;
                prev=temp1;
                temp2=temp2.next;
                temp1=temp1.next;
            }
            
            while(carry !=0 && temp1!=null){
            int sum=temp1.val + carry;
            temp1.val=sum%10;
            carry=sum/10;
            prev=temp1;
            temp1=temp1.next;
            }

            if(carry >0)
            prev.next=new ListNode(carry);

            return l1;


        }


        else{
            ListNode temp1=l1;
            ListNode temp2=l2;
            ListNode prev=null;
            int carry=0;

            while(temp1 != null){
                int sum=temp1.val+temp2.val+carry;
                temp2.val=sum%10;
                carry=sum/10;
                prev=temp2;
                temp1=temp1.next;
                temp2=temp2.next;
            }

            while(temp2 != null){
                int sum=temp2.val+carry;
                temp2.val=sum%10;
                carry=sum/10;
                prev=temp2;
                temp2=temp2.next;
            }

            if(carry >0)
            prev.next=new ListNode(carry);

            return l2;


        }
    }

    public int length(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        int cnt=0;

        while(curr != null){
            cnt++;
            curr=curr.next;    
        }

        return cnt;
    }
}