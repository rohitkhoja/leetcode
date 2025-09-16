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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode listNode = new ListNode();
        ListNode head = listNode;
        if(list1.val<list2.val){
            listNode.val = list1.val;
            list1 = list1.next;
        }
        else{
            listNode.val = list2.val;
            list2 = list2.next;
        }
        while(list1!=null && list2!=null){
            ListNode listNode1 = new ListNode();
            
            if(list1.val<list2.val){
                listNode1.val = list1.val;
                list1 = list1.next;
            }
            else{
                listNode1.val = list2.val;
                list2 = list2.next;
            }
            head.next = listNode1;
            head = listNode1;

        }
        while(list1!=null){
            ListNode listNode1 = new ListNode();
            
            
            listNode1.val = list1.val;
            list1 = list1.next;
            
            head.next = listNode1;
            head = listNode1;
        }
        while(list2!=null){
            ListNode listNode1 = new ListNode();
            
            
            listNode1.val = list2.val;
            list2 = list2.next;
            
            head.next = listNode1;
            head = listNode1;
        }
        return listNode;
    }
}