class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack  = new ArrayDeque<>();
        int result = 0 ;
        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                if(token.equals("+")) result = a+b;
                else if(token.equals("-")) result = b-a;
                if(token.equals("*")) result = a*b;
                if(token.equals("/")) result = b/a;
                stack.push(result);
            }
            else stack.push(Integer.parseInt(token));
        }
        return stack.peek();
    }
}