class LRUCache {

    int capacity;
    Node head;
    Node tail;


    class Node{
        int value;
        int key;
        Node prev;
        Node next;

        public Node(int value, int key, Node prev, Node next){
            this.value = value;
            this.key  = key;
            this.prev = prev;
            this.next = next;
        }
    }


    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0, null, null);
        this.tail = new Node(0, 0, null, null);
        head.prev = tail;
        tail.next = head;
    }
    
    public int get(int key) {

        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.prev = head.prev;
        head.prev.next = node;
        node.next = head;
        head.prev = node;
        return node.value;

    }
    
    public void put(int key, int value) {
        //System.out.println(key);
        if(map.containsKey(key)) removeNode(map.get(key));
        if(map.size()==capacity) removeNode(tail.next);
        Node node = new Node(value, key, null, null);
        node.prev = head.prev;
        head.prev.next = node;
        node.next = head;
        head.prev = node;
        map.put(key, node);
    }



    public void removeNode(Node node){
        int key = node.key;
        node.next.prev = node.prev;
        node.prev.next = node.next;
        map.remove(key);
    }

    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */