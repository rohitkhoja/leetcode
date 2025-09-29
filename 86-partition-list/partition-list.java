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
        ListNode tempFirst = head;
        ListNode tempMid = null;
        ListNode tempLast = head;
        while(tempLast!=null){
            while(tempFirst!=null && tempFirst.val<x) tempFirst = tempFirst.next;
            if(tempFirst==null) return head;
            tempLast = tempFirst.next;
            while(tempLast!=null) {
                if(tempLast.val>=x) tempMid = tempLast;
                else break;
                tempLast = tempLast.next;
            }
            if(tempLast==null) return head;
            if(tempMid!=null) {
                int val = tempMid.val;
                tempMid.val = tempLast.val;
                tempLast.val = val;
                tempLast = tempMid;
                tempMid = null;
            }
            else{
                int val = tempFirst.val;
                tempFirst.val = tempLast.val;
                tempLast.val = val;
                tempLast = tempLast.next;
                tempFirst = tempFirst.next;
            }
            

        }
        return head;
        
    }
}