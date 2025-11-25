class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        int i=0;
        //dp[0][0]=1;
        while(i<m && obstacleGrid[i][0]!=1){
            dp[i][0] = 1;
            i++;
        }
            
        i=0;
        while(i<n && obstacleGrid[0][i]!=1){
            dp[0][i] = 1;
            i++;
        }

        for(i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]!=1)
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    //System.out.println(i+" ."+j+" ."+ dp[i][j]);
            }
        }  

        return dp[m-1][n-1];  

    }
}