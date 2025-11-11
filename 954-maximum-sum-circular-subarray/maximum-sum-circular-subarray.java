class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        int result = Integer.MIN_VALUE;
        int lastIndex = 0;
        int total = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            total += nums[i];
            if(sum>0)
                sum += nums[i];
            else{
                 
                sum  = nums[i];
            }  
            result = Math.max(result, sum);        
        }
        
        if(result<0) return result;

        sum = 0;
        for(int i=0; i<nums.length; i++){
            if(sum>0)
                sum  = nums[i];
            else{
                sum += nums[i];
            }  
            min = Math.min(min, sum);        
        }
        
        return Math.max(result, total-min);
    }
}