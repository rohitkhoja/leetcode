class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                //if(nums[j]==nums[j+1]) continue;
                long temp = (long) target - nums[j] - nums[i];
                int k = j+1;
                int l = n-1;
                while(k<l){
                    if((long) nums[k]+nums[l] < temp) k++;
                    else  if((long) nums[k]+nums[l] > temp) l--;
                    else {
                        System.out.println(nums[k]+nums[l] +" "+ temp+ " "+ nums[i]+ " "+nums[j]);
                        List<Integer> list = List.of(nums[i],nums[j],nums[k],nums[l]);
                        if(!result.contains(list)) result.add(list);
                        k++;
                        //while(nums[k]==nums[k-1] && k<l) k++;

                    }


                }
            }
        }
        return result;
    }
}