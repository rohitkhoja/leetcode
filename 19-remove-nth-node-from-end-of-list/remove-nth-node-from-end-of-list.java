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
        int l=0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            l++;
        }
        
        n = l-n;
        if(n==0){
            return head.next;
        }
        l=0;
        temp  = head;
        while(l<n-1){
            temp = temp.next;
            l++;
        }
        temp.next = temp.next.next;
        return head;
        
    }
}