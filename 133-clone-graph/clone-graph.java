/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return node;
        Node newNode = new Node(node.val);
        Map<Node, Node> map = new HashMap<>();
        map.put(node,newNode);
        Set<Integer> nodes = new HashSet<>();
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        nodes.add(node.val);

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            List<Node> newNeighbors = new ArrayList<Node>();
            for(Node n: temp.neighbors){
                if(!nodes.contains(n.val)){
                    Node newNode1 = new Node(n.val);
                    map.put(n,newNode1);
                    newNeighbors.add(newNode1);
                    nodes.add(n.val);
                    queue.offer(n);
                }
                else{
                    if(map.containsKey(n)) {
                        Node newNode1 = map.get(n);
                        newNeighbors.add(newNode1);
                    }
                    else newNeighbors.add(n);
                }
            }
            temp = map.get(temp);
            temp.neighbors = newNeighbors;
        }
        return newNode;
    }
}