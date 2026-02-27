// /*
// // Definition for a Node.
// class Node {
//     int val;
//     Node next;
//     Node random;

//     public Node(int val) {
//         this.val = val;
//         this.next = null;
//         this.random = null;
//     }
// }
// */

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        Node new1 = new Node(-1);
        Node temp1 = new1;
        while(head!=null){
            Node new2 = new Node(head.val);
            map.put(head,new2);
            new1.next = new2;
            head = head.next;
            new1 = new2;
        }

        head = temp;
        new1 = temp1.next;

        while(head!=null){
            Node n = map.get(head.random);

            new1.random = n;

            new1 = new1.next;
            head = head.next;
        }

        return temp1.next;

    }
}












// /*
// // Definition for a Node.
// class Node {
//     int val;
//     Node next;
//     Node random;
//     public Node(int val) {
//         this.val = val;
//         this.next = null;
//         this.random = null;
//     }
// }
// */

// class Solution {
//     public Node copyRandomList(Node head) {
//         Map<Node,Integer> mapOrigional = new HashMap<>();
//         Map<Integer,Node> mapNew = new HashMap<>();
//         int index = 0; 
//         if(head==null) return head;
        
//         Node nodeHead  = new Node(head.val);
//         Node traverse = nodeHead;
//         Node headSecond = head;
        
//         mapOrigional.put(head, index);
//         mapNew.put(index, nodeHead);

//         head = head.next;
//         index++;
//         while(head!=null){
//             Node node  = new Node(head.val);
//             traverse.next = node;
//             traverse = node;
//             mapOrigional.put(head, index);
//             mapNew.put(index, node);
//             head = head.next; 
//             index++;
//         }
        
//         traverse = nodeHead;
        
        
//         while(headSecond!=null){
            
//             if(headSecond.random!=null){
//                 int index1 = mapOrigional.get(headSecond.random);
                
//                 Node node1 = mapNew.get(index1);
                
//                 traverse.random = node1;
//             }
//             traverse = traverse.next;
//             headSecond = headSecond.next;
//         }

//         return nodeHead;
//     }
// }