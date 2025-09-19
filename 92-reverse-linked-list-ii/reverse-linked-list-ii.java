/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }y
 */

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        int index = 1;
        ListNode returnHead = head;
        ListNode leftBefore = null;
        while(index!=left){
            leftBefore = head;
            head = head.next;
            index++;
        }
        
        ListNode leftNode = head;
        ListNode lastNode = head;
        while(index!=right){
            if(index==left){
                lastNode = head;
                head = head.next;
            }
            else{
                ListNode next = head.next;
                head.next = lastNode;
                lastNode  = head;
                head = next;
            }
            index++;
        }
        leftNode.next = head.next;
        head.next = lastNode;
        if(leftBefore!=null) leftBefore.next = head;
        if(left>1)return returnHead;
        else return head;
        
    }
}