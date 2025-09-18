/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Integer> mapOrigional = new HashMap<>();
        Map<Integer,Node> mapNew = new HashMap<>();
        int index = 0; 
        if(head==null) return head;
        
        Node nodeHead  = new Node(head.val);
        Node traverse = nodeHead;
        Node headSecond = head;
        
        mapOrigional.put(head, index);
        mapNew.put(index, nodeHead);

        head = head.next;
        index++;
        while(head!=null){
            Node node  = new Node(head.val);
            traverse.next = node;
            traverse = node;
            mapOrigional.put(head, index);
            mapNew.put(index, node);
            head = head.next; 
            index++;
        }
        
        traverse = nodeHead;
        
        
        while(headSecond!=null){
            
            if(headSecond.random!=null){
                int index1 = mapOrigional.get(headSecond.random);
                
                Node node1 = mapNew.get(index1);
                
                traverse.random = node1;
            }
            traverse = traverse.next;
            headSecond = headSecond.next;
        }

        return nodeHead;
    }
}