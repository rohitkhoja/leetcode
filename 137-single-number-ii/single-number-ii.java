class Solution {
    public int singleNumber(int[] nums) {
        
        Set<Integer> set  = new HashSet<>();
        int result = 0;
        Set<Integer> set2 = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]))
                set2.add(nums[i]);
            else set.add(nums[i]);  
            result ^= nums[i];  
        }
        for(int n:set2){
            result ^= n; 
        }

        return result;
    }
}