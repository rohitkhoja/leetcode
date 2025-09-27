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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null){
            if(temp.next!=null && temp.val==temp.next.val){
                while(temp.next!=null && temp.val==temp.next.val)
                    temp.next = temp.next.next;
                if(prev == null) {
                    head = temp.next;
                    temp = head;
                }
                else{
                    prev.next = temp.next;
                    temp = temp.next;
                }    
            }
            else {
                prev = temp;
                temp = temp.next;
            }
            

        }
        return head;
        
    }
}