class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = Integer.MAX_VALUE-100000;

        for(int i=0;i<n-2;i++){
            int j=i+1;
            int k = n-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(Math.abs(target-sum)<Math.abs(target-result)){
                    result = sum;
                    //System.out.println(sum);
                } 
                
                if(sum>target) k--;
                else if(sum<target) j++;
                else return result;
            }

        }
        return result;

    }

    
}