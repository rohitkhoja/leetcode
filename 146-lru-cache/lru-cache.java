class ListNode {
    int val;
    int key;
    ListNode front;
    ListNode back;
    public ListNode(){}
    public ListNode(int val, int key){this.val = val;this.key = key;}
}
class LRUCache {
    private Map<Integer, ListNode> map;
    private int size;
    ListNode tail = null;
    ListNode head = null;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        size = capacity;
        
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        ListNode node = map.get(key);
        if(node == head) return head.val;
        node.front.back = node.back;
        if(node!=tail)
            node.back.front = node.front;
        else
            tail = node.front;
        head.front = node;
        node.back = head;
        node.front = null;
        head = node;
        return head.val;
        
    }
    
    public void put(int key, int value) {
        
        
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            node.val = value;
            if(node!=head) {
                node.front.back = node.back;
                if(node!=tail)
                node.back.front = node.front;
                else
                tail = node.front;
                head.front = node;
                node.back = head;
                node.front = null;
                head = node;
            }
            
        }
        else {
            if(map.size()==size ){
                ListNode node =  map.get(tail.key);
                ListNode temp = node.front;
                node.front = null;
                if(temp!=null)
                temp.back = null;
                map.remove(tail.key);
                tail = temp;
            }
            ListNode temp =  new ListNode(value,key);
            if(tail==null){
                tail = temp;
                head = tail;
            }
            else{
                head.front = temp;
                temp.back = head;
                head = temp;
            }
        }
            

        map.put(key,head);
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */