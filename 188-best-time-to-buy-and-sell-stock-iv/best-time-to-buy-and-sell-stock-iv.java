class Solution {
    public int maxProfit(int k, int[] prices) {
        
        int[] buy = new int[k];
        int[] sell = new int[k];
        for(int i=0;i<k;i++){
            buy[i] = Integer.MIN_VALUE;
            sell[i] = 0;
        }
        int n = prices.length;

        for(int i=0; i<n; i++){
            buy[0] = Math.max(buy[0], -prices[i]);
            sell[0] = Math.max(sell[0], buy[0] + prices[i]);

            for(int j=1;j<k;j++){
                buy[j] = Math.max(buy[j], sell[j-1]-prices[i]);
                sell[j] = Math.max(sell[j], buy[j]+prices[i]);
            }
        }
        return sell[k-1];
    }
}