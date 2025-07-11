class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int result = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                result = Math.min(result, i-map.get(nums[i]));
            }
            map.put(nums[i],i);
        }
        return result<=k;
    }
}