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
    public ListNode rotateRight(ListNode head, int k) {
        int l=0;
        ListNode temp = head;
        while(temp!=null){
            if(temp.next==null){
                temp.next = head;
                l++;
                break;
            }
            temp = temp.next;
            l++;
        }
        if(l==0) return head;
        k%=l;
        temp = head;
        k = l-k;
        while(k>1){
            temp=temp.next;
            k--;
        }
        head = temp.next;
        temp.next = null;
        return head;
            
        
        

        

        
    }
}