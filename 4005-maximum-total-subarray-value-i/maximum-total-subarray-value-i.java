class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long min = Long.MAX_VALUE;
        long max = -1;
        for(int num : nums){
            if(num>max)  max = num;
            if(num<min) min = num;
        }
        long result = k * (max-min);
        return result;
    }
}