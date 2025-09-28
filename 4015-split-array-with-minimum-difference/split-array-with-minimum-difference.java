class Solution {
    public long splitArray(int[] nums) {
        int leftIndex = nums.length;
        int rightIndex = 0;
        long leftSum = nums[0];
        long rightSum = 0;
        int i=1;
        for(;i<nums.length-1;i++){
            if(nums[i]>nums[i-1]) {
                rightIndex = i;
                leftSum+=nums[i];
            }
            else break;
        }
        rightSum = nums[i];
        i++;
        for(;i<nums.length;i++){
            if(nums[i]<nums[i-1]) {
                rightSum+=nums[i];
            }
            else break;
        }
        if(i!=nums.length) return -1;
        
        long result = Math.abs(leftSum-rightSum);
        
        if(rightIndex>0 && nums[rightIndex]>nums[rightIndex+1])
        result = Math.min(result,Math.abs(2*nums[rightIndex]+rightSum-leftSum));
        return result;
        
    }
}