class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] amounts = new int[amount+1];
        amounts[0] = 0;

        for(int i=1;i<amount+1;i++){
            for(int coin: coins){
                if(i-coin>=0 && amounts[i-coin]!=-1){
                    if( amounts[i] !=0 && amounts[i] !=-1 )
                        amounts[i] = Math.min( amounts[i], amounts[i-coin]+1);
                    else amounts[i] =  amounts[i-coin]+1;   
                }
                else if( amounts[i] ==0 )amounts[i] = -1;
                //System.out.println(i+". "+amounts[i]);
            }
        }

        return amounts[amount];
    }
}