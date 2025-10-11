class Solution {

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        int[] x = {1,-1,0,0};
        int[] y = {0,0,1,-1};
        int result = 0;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(grid[i][j]=='1'){
                    // System.out.println(i);
                    // System.out.println(j);
                    grid[i][j]='0';
                    q.offer(new int[]{i,j});
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        for(int k=0;k<4;k++){
                            int i1 = curr[0]+x[k];
                            int j1 = curr[1]+y[k];
                            if(i1>=0 && i1<n && j1>=0 && j1<m && grid[i1][j1]=='1'){
                                System.out.println(i);
                                System.out.println(j);
                                grid[i1][j1]='0';
                                q.offer(new int[]{i1,j1});
                            }
                        }
                    }
                    result++;
                }

        return result;
        
    }
}