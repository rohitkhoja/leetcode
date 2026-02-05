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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;

        ListNode current = head;
        ListNode next = head.next;
        ListNode result = next;
        while(current!=null && next!=null){
            ListNode temp = next.next;
            current.next = next.next;
            next.next = current;
            //current = temp;
            if(temp!=null && temp.next!=null) {
                current.next = temp.next;
                next = temp.next;
                current = temp;
            }
            else break;
        }
        return result;
    }
}