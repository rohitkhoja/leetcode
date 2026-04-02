class Solution {

    public void visit(int[][] grid, int x, int y){
        Deque<int[]> q = new ArrayDeque<>();
        int[] X = {1,-1,0,0};
        int[] Y = {0,0,1,-1};
        int n = grid.length;
        int m = grid[0].length;
        q.add(new int[]{x,y});
        grid[x][y]=0;
        while(!q.isEmpty()){
            int[] arr = q.poll();
            
            for(int i=0;i<4;i++){
                int x1 = X[i]+arr[0];
                int y1 = Y[i]+arr[1];
                if(x1>=0 && y1>=0 && x1<n && y1<m && grid[x1][y1]==1){
                    q.add(new int[]{x1, y1});
                    grid[x1][y1]=0;
                }
                    
            }
        }

    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] x = {1,-1,0,0};
        int[] y = {0,0,1,-1};

        
        int result = 0;

        for(int i=0;i<n;i++){
            if(grid[i][0]==1) visit(grid, i, 0);
            if(grid[i][m-1]==1) visit(grid, i, m-1);
        }

        for(int i=0;i<m;i++){
            if(grid[0][i]==1) visit(grid, 0, i);
            if(grid[n-1][i]==1) visit(grid, n-1, i);
        }

        

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(grid[i][j]==1) result++;
            }
        }

        return result;

    }
}