class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<String> fresh = new HashSet<>();
        List<int []> rotten = new ArrayList<>();
        int[] x = {1,-1,0,0};
        int[] y = {0,0,1,-1};
        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                if(grid[i][j]==1){
                    fresh.add(i+","+j);
                }
                if(grid[i][j]==2){
                    rotten.add(new int[]{i,j});
                }
            }
        }
        int minutes = 0;
        while(!fresh.isEmpty()){
            int i = fresh.size();
            List<int []> newRotten = new ArrayList<>();
            for(int[] r: rotten){
                for(int k=0; k<4; k++){
                    int x1 = r[0]+x[k];
                    int y1 = r[1]+y[k];
                    String check = x1+","+y1;
                    if(x1<m && x1>=0 && y1<n && y1>=0 && fresh.contains(check)){
                        fresh.remove(check);
                        newRotten.add(new int[]{x1,y1});
                    }
                }
            }
            rotten = newRotten;
            if(i==fresh.size()) return -1;
            minutes++;
        }

        return minutes;
    }
}