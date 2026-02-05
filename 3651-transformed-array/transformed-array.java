class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for(int i=0;i<n;i++){
            int res = nums[i]%n;
            if(nums[i]>0){
                result[i] = nums[(i+nums[i])%n];
            }
            else if(nums[i]<0){
                result[i] = nums[(i+Math.abs(n+res))%n];
            }
            else result[i] = nums[i];

        }

        return result;
    }
}