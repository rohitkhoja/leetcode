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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;

        ListNode fast = head;
        ListNode slow = head;

        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        boolean check = false;
        if(fast.next==null) check = true;
        //slow = slow.next;
        ListNode prev = slow.next;
        ListNode curr = slow.next.next;

        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        while(head!=slow){
            //System.out.println(prev.val+" "+head.val);
            if(prev.val!=head.val) return false;
            head = head.next;
            prev = prev.next;
            
        }
        //System.out.println(fast.val);
        if(check) {
           //System.out.println("sss"); 
           return true;
        }
        return prev.val==head.val;


        
    }
}