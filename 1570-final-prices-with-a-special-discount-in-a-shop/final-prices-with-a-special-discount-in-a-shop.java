class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] dis = new int[n];

        for(int i=0;i<n;i++){
            dis[i]=0;
            int j=i+1;
            while(j<n && prices[j]>prices[i]) j++;
            if(j!=n) dis[i] = prices[j];
        }

        for(int i=0;i<n;i++){
            prices[i] -= dis[i];
        }

        return prices;
        
    }
}