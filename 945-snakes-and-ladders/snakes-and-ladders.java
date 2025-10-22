class Solution {
    Set<Integer> visited;
    int n=0;
    Map<Integer, Integer> map;



    public int snakesAndLadders(int[][] board) {
        map = new HashMap<>();
        n = board.length;
        boolean flip = false;
        int index = 0;
        for(int i=n-1;i>=0;i--){
            if(flip){
                for(int j=n-1;j>=0;j--){
                    index++;
                    if(board[i][j]!=-1)
                    map.put(index,board[i][j]);
                }
                
            }
            else{
               for(int j=0;j<n;j++){
                    index++;
                    if(board[i][j]!=-1)
                    map.put(index,board[i][j]);
                } 
            }
            flip = !flip;
        }  
        visited = new HashSet<>();
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        int result = 0;
        visited.add(1);
        while(!q.isEmpty()){
            
            int sz = q.size();
            for(int i=0;i<sz;i++){
                int curr = q.poll();
                if(curr == n*n) return result; 
                for(int k=1; k<7 && curr+k<=n*n ; k++){
                    int next = curr+k;
                    if(map.containsKey(next)) 
                        next =  map.get(next);
                    if(!visited.contains(next)){
                        q.offer(next);
                        visited.add(next);

                    }
                        
                }

            }
            result++;
        }
            
        return -1;
    }
}