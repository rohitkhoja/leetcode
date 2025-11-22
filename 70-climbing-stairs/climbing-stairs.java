class Solution {
    public int climbStairs(int n) {

        int[] rSteps = new int[n+1];
        rSteps[0] = 0;
        rSteps[1] = 1;
        if(n==1) return 1;
        rSteps[2] = 2;
        for(int i=3;i<=n;i++){
            rSteps[i] = rSteps[i-1] + rSteps[i-2] ;
        }
        return rSteps[n];
        
    }
}