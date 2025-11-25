class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        int[] pSum = new int[n];
        if(n==1) return nums[0];
        for(int i=0;i<n;i++){
            if(i-3>=0){
                pSum[i] = Math.max(pSum[i-2], pSum[i-3]);
            }
            else if(i-2>=0){
                pSum[i] = pSum[i-2];
            }
            else pSum[i] = 0;

            pSum[i] += nums[i];
        }
        
        return Math.max(pSum[n-1], pSum[n-2]);    
        
    }
}