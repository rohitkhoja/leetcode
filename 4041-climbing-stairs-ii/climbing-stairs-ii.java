class Solution {
    public int climbStairs(int n, int[] costs) {
        int cost = 0;
        
        int[] costAll = new int[n+1];
        costAll[0]=0;
        for(int i=0;i<n;i++){
            int c1=Integer.MAX_VALUE,c2=Integer.MAX_VALUE,c3=Integer.MAX_VALUE;
            if(i-2>=0)
                c1 = costs[i] + 9 + costAll[i-2];
            if(i-1>=0)
                c2 = costs[i] + 4 + costAll[i-1];
            if(i>=0)
                c3 = costs[i] + 1 + costAll[i];
            
            int c = Math.min(c1,Math.min(c2,c3));
            costAll[i+1] = c;
        }

        return costAll[n];
        
    }
}