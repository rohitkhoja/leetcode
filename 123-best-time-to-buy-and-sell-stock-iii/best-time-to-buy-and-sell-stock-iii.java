class Solution {
    public int maxProfit(int[] prices) {

        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        int buy2 = Integer.MIN_VALUE;
        int sell2 = 0;
        int n = prices.length;

        for(int i=0; i<n; i++){

            buy1 = Math.max(buy1, -prices[i]);
            
            sell1 = Math.max(sell1, buy1+prices[i]);
            buy2  = Math.max(buy2, sell1-prices[i]);
            sell2 = Math.max(sell2, buy2+prices[i]);
            //System.out.println(buy1+ " buy1 "+sell1+ " sell1 "+buy2+ " buy2 "+sell2+ " sell2 ");
        }
        
        return sell2;
    }
}