/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false;
        ListNode nextNode = head;
        ListNode nextNode1 = head;

        while(nextNode1!=null && nextNode1.next!= null){
            nextNode = nextNode.next;
            nextNode1 = nextNode1.next.next;
            if(nextNode1==nextNode) return true;
        }
        return false;
    }
}