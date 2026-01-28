class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(int ast: asteroids){

            if(!stack.isEmpty() && stack.peek()>0 && ast<0){
                if(stack.peek()>Math.abs(ast)){
                    continue;
                }
                else{
                    //boolean ex = false;
                    while(!stack.isEmpty() && stack.peek()>0 &&stack.peek()<Math.abs(ast)){
                        stack.pop();
                    }
                    if(stack.isEmpty() || stack.peek()<0) stack.push(ast);
                    if(!stack.isEmpty() && stack.peek()>0 && stack.peek()==Math.abs(ast)){
                        stack.pop();
                    }
                }
                //else stack.pop();

            }
            else stack.push(ast);
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        return result;
    }
}