class Solution {

    class Pair{
        int num;
        int count;

        public Pair(int num, int count){
            this.num = num;
            this.count = count;
        }
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n];
        
        int result = 1;
        for(int i=n-1;i>=0;i--){
            int count = 1;
            for(int j=i+1; j<n; j++){
                if(nums[j]>nums[i])
                    count = Math.max(count,counts[j]+1);
            }
            counts[i] = count;
            result = Math.max(result, count);
        }
        
        return result;
    }
}