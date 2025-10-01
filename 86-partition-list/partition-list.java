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
    public ListNode partition(ListNode head, int x) {
        if(head==null) return head;
        ListNode left = null;
        ListNode right = null;
        ListNode leftHead = null;
        ListNode rightHead = null;
        while(head!=null){
            if(head.val<x){
                if(left==null){
                    left = head;
                    leftHead = head;
                }
                else {
                    left.next = head;
                    left = head;
                }
            }
            else {
                if(right==null){
                    right = head;
                    rightHead = head;
                }
                else {
                    right.next = head;
                    right = head;
                }
            }
            head = head.next;
        }   
        if(right==null) return leftHead;
        if(left==null) return rightHead;
        right.next = null;
        left.next = rightHead;
        return leftHead;
        
        

        
        
    }
}