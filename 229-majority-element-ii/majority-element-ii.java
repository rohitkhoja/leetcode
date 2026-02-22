class Solution {
    public List<Integer> majorityElement(int[] nums) {

        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            int count = 1;
            while(i+1<n && nums[i]==nums[i+1]) {
                count++;
                i++;
            }
            //i--;
            if(count > n/3) list.add(nums[i]);
        }

        return list;
    }
}