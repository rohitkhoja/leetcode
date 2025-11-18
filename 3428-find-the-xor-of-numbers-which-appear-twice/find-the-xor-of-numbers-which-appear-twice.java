class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]))
                list.add(nums[i]);
            else    
                set.add(nums[i]);
        }
        int result = 0;
        for(int i=0;i<list.size();i++)
            result ^= list.get(i);

        return result;
    }
}