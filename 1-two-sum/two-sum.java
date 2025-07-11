class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],0);
        for(int i=1;i<nums.length;i++){
            int n = target - nums[i];
            if(map.containsKey(n)){
                return new int[]{map.get(n),i};
            }
            else map.put(nums[i],i);
        }
        return new int[] {0,0};
    }
}