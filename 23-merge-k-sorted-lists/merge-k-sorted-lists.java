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
    class Pair{
        int x;
        ListNode n;

        Pair(int x, ListNode n){
            this.x = x;
            this.n = n;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.x,b.x));
        ListNode node = new ListNode(-1);
        ListNode temp = node;
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                pq.add(new Pair(lists[i].val, lists[i].next));
            }
        }
        
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            //System.out.println(p.x);
            node.next = new ListNode(p.x);
            node = node.next;
            
            if(p.n!=null){
                p.x = p.n.val;
                p.n = p.n.next;
                pq.add(p);
            }
        }
        return temp.next;
    }
}