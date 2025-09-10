class Solution {
    public boolean isValid(String s) {

        Deque<Character> stack  = new ArrayDeque<>();
        int l = s.length();
        for(int i=0;i<l;i++){
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='[')
                stack.push(c);
            else{
                if(stack.isEmpty() ) return false;
                char openBracket = stack.pop();
                boolean condition = ((openBracket=='(' && c==')') || 
                                    (openBracket=='{' && c=='}') ||
                                    (openBracket=='[' && c==']'));
                if(!condition) return false;                    
            }    
          
        }
        if(!stack.isEmpty()) return false;
        else return true;

        
    }
}