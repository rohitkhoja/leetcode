class Solution {
    public int minRemoval(int[] nums, int k) {

        Arrays.sort(nums);
        int n = nums.length;

        int l = 0;
        int result = n+1;;
        for(int i=0;i<n;i++){
            while(nums[i] > (long) nums[l]*k) l++;
            result = Math.min(result, n - (i-l+1));
        }
        return result;
    }
}