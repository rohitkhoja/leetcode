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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry = 0;
        ListNode listNode = new ListNode();
        ListNode head = listNode;
        int value = l1.val + l2.val;
        if(value>9){
            value-=10;
            carry = 1;
        }
        listNode.val = value;
        l1 = l1.next;
        l2 = l2.next;

        while(l1!=null && l2!=null){
            ListNode listNode1 = new ListNode();
            value = l1.val + l2.val + carry;
            carry = 0;
            if(value>9){
                value -= 10;
                carry = 1;
            }
            listNode1.val = value;
            head.next = listNode1;
            head = listNode1;
            l1 = l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            ListNode listNode1 = new ListNode();
            value = l1.val  + carry;
            carry = 0;
            if(value>9){
                value -= 10;
                carry = 1;
            }
            listNode1.val = value;
            head.next = listNode1;
            head = listNode1;
            l1 = l1.next;
        }
        while(l2!=null){
            ListNode listNode1 = new ListNode();
            value = l2.val  + carry;
            carry = 0;
            if(value>9){
                value -= 10;
                carry = 1;
            }
            listNode1.val = value;
            head.next = listNode1;
            head = listNode1;
            l2 = l2.next;
        }
        if(carry == 1){
            ListNode listNode1 = new ListNode();
            listNode1.val = 1;
            head.next = listNode1;
            head = listNode1;
        }
        return listNode;
    }
}