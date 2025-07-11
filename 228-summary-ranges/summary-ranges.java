class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int initial = nums[i];
            int last = nums[i];
            while(i+1<nums.length && nums[i+1]==nums[i]+1){
                i++;
                last = nums[i];
            }
            
            if(initial==last) result.add(initial+"");
            else
            result.add(initial+"->"+last);
        }
        return result;
    }
}