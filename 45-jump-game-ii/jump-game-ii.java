class Solution {
    public int jump(int[] nums) {
        int[] result = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            result[i] = Integer.MAX_VALUE;
        }
        result[0] = 0;
        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            for(int j=i+1;j<=n+i && j<nums.length;j++){
                result[j] = Math.min(result[j], result[i]+1);
            }
        }

        return result[nums.length-1];
    }
}