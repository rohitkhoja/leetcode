/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Node prev = null;
        Node dummy  = new Node(-1000);
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        queue.offer(dummy);
        while(!queue.isEmpty() && queue.peek().val!=-1000){
            while(queue.peek().val!=-1000){
                Node temp = queue.poll();
                if(prev==null) prev=temp;
                else{
                    prev.next = temp;
                    prev = temp;
                }
                if(temp.left!=null) queue.offer(temp.left);
                if(temp.right!=null) queue.offer(temp.right);
            }
            queue.poll();
            prev = null;
            queue.offer(dummy);
        }

        return root;        
    }
}