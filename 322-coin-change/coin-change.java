class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] amounts = new int[amount+1];

        amounts[0] = 0;

        for(int i=1;i<amount+1;i++){
            amounts[i] = -1;
            for(int coin:coins){
                if(coin<=i && amounts[i-coin]!=-1){
                    if(amounts[i]>0){
                        amounts[i] = Math.min(amounts[i], amounts[i-coin]+1);
                    }
                    else amounts[i] = amounts[i-coin]+1;
                }
            }
        }

        return amounts[amount];
        
    }
}