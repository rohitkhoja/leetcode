class Solution {
    public int longestSubarray(int[] nums) {
        int l = nums.length;
        int max = 2;
        int result = 2;
        for(int i=2; i<l;){
            if(nums[i] == (nums[i-1]+nums[i-2])){
                while(i<l && nums[i] == (nums[i-1]+nums[i-2])) {
                    max++;
                    i++;
                }
                result = Math.max(result, max);
                max = 2;
            }
            else {
                i++;
            }
        }
        return result;
    }
}