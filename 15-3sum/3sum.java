class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length-1;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            else {
                int j=i+1;
                int k=nums.length-1;
                while(j<k){
                    int t = nums[i]+nums[j]+nums[k];
                    if(t>0) k--;
                    else if(t<0) j++;
                    else{
                        result.add(new ArrayList<>(List.of(nums[i],nums[j],nums[k])));
                        j++;
                        while(nums[j-1]==nums[j] && j<k) j++;
                    }

                } 
            }
        }
        return result;
    }
}