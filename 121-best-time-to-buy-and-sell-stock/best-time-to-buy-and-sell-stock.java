class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        int n = prices.length;
        for(int i=1;i<n;i++){
            maxProfit = Math.max(maxProfit,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return maxProfit;
    }
}