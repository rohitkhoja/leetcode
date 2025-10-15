class Solution {
    Deque<int[]> queue = new ArrayDeque<>();
    
    int n = 0;
    int m = 0;
    int[] x = {1,-1,0,0};
    int[] y = {0,0,1,-1};
    int i1=0;
    int j1=0;
    public void traverse(int[] node, char[][] board, boolean[][] visited){
        queue.offer(node);
        visited[node[0]][node[1]]=true;
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int q=0;q<4;q++){
                i1 = temp[0]+x[q];
                j1 = temp[1]+y[q];
                if(i1>=0 && i1<n && j1>=0 && j1<m && 
                    !visited[i1][j1] && board[i1][j1]=='O'){
                    visited[i1][j1]= true;
                    queue.offer(new int[]{i1,j1});
                }
            }
            
        }
    }
    public void solve(char[][] board) {

        n = board.length;
        m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && !visited[i][0]){
               traverse(new int[]{i,0}, board, visited);
            }
            if(board[i][m-1]=='O' && !visited[i][m-1]){
               traverse(new int[]{i,m-1}, board, visited);
            }
        }
        for(int j=0;j<m;j++){
            if(board[0][j]=='O' && !visited[0][j]){
               traverse(new int[]{0,j}, board, visited);
            }
            if(board[n-1][j]=='O' && !visited[n-1][j]){
               traverse(new int[]{n-1,j}, board, visited);
            }
        }

        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(board[i][j]=='O' && !visited[i][j]){
                    board[i][j]='X';
                }
            }
        }

        
    }
}