class Solution {
    public int calculate(String s) {
        int result = 0;
        int num = 0;
        boolean op = true;
        Deque<Integer> number = new ArrayDeque<>();
        Deque<Boolean> operation = new ArrayDeque<>();

        for( char c: s.toCharArray()){
            if(c=='('){
                number.push(result);
                operation.push(op);
                num=0;
                result=0;
                op=true;
            }
            else if (c==')'){
                result = calc(result, num, op);
                result = calc(number.pop(), result,operation.pop());
                num=0;
                op =true;
            }
            else if ( c==' '){
                continue;
            }
            else if (c=='+'){
                result = calc(result, num, op);
                num=0;
                op =true;
            }
            else if(c=='-'){
                
                result = calc(result, num, op);
                num=0;
                op =false;
            }
            else{
                num = (10*num) + c-'0';
            }

        }
        return calc(result, num, op);
        
    }

    public int calc(int result, int num, boolean op){
        if(!op) num = -num;
        result += num;
        return result;
    }
}