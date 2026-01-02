class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int n = nums.length;
        for(int i=0;i<n;i++){
            if(set.contains(nums[i])) return nums[i];
            set.add(nums[i]);
        }
        return 0;
    }
}