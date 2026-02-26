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
        if(head==null || k==1) return head;

        ListNode node = head;
        int index = 0;
        while(node!=null && index!=k){
            node = node.next;
            index++;
        }
        if(index!=k) return head;

        ListNode newHead = reverseKGroup(node, k);
        
        ListNode prev = head;
        ListNode curr = head.next;
        head.next = newHead;
        while(index>1){
            //System.out.println(curr.val);
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            index--;
        }

        return prev;
        
    }
}