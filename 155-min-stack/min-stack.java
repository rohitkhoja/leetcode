class MinStack {
    private Deque<Integer> stack;
    private int min;
    public MinStack() {
        stack  = new ArrayDeque<>();
        min = Integer.MAX_VALUE;  
    }
    
    public void push(int val) {
        stack.push(val);
        if(val < min) min = val;
    }
    
    public void pop() {
        int val = stack.pop();
        if(val==min){
            min = Integer.MAX_VALUE;
            Deque<Integer> stack1  = new ArrayDeque<>();
            while(!stack.isEmpty()){
                val = stack.pop();
                min = Math.min(min, val);
                stack1.push(val);
            }
            while(!stack1.isEmpty()){
                val = stack1.pop();
                stack.push(val);
            }
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */