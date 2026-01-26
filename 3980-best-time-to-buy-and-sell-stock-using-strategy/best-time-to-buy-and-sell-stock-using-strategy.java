class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        
        int[] modified = new int[k];
        for(int i=0;i<k/2;i++){
            modified[i] = 0;
            modified[k/2+i] = 1;
        }

        long result = 0;
        int n = prices.length;
        long sum = 0;
        for(int i=0;i<n;i++){
            sum += strategy[i]*prices[i];
        }
        
        for(int i=0;i<k;i++){
            result += modified[i]*prices[i];
        }
        
        for(int i=k;i<n;i++){
            result += strategy[i]*prices[i];
        }
        
        //System.out.println(sum+" ");
        sum  = Math.max(sum, result);
        //System.out.println(sum+" ");

        for(int i=1;i<=n-k;i++){
            result += strategy[i-1]*prices[i-1];
            //System.out.println(result+" ");
            result -= prices[i-1+k/2];
            //System.out.println(result+" ");
            result -= strategy[i-1+k]*prices[i-1+k];
            result += prices[i-1+k];
            sum  = Math.max(sum, result);
            //System.out.println(sum+" ");
        }
        return sum;
    }
}