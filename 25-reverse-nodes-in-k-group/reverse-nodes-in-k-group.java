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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode prev = null;
        ListNode intervalTail = null;
        ListNode intervalHead = null;
        ListNode resultnode = head;
        ListNode curr = head;
        ListNode next = null;
        int index = 0;
        while(head!=null){
            intervalHead = curr;
            prev = curr;
            curr = curr.next;
            head = head.next;
            index++;
            while(head!=null && index%k!=0){
            head = head.next;
            index++;
            }
            if(index%k!=0) break;
            while(curr!=head){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            if(intervalTail!=null) intervalTail.next = prev;
            intervalTail = intervalHead;
            if(index==k) resultnode = prev;
            intervalTail.next = curr;
        }
        return resultnode;
        
        
    }
}


