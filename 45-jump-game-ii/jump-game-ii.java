class Solution {
    public int jump(int[] nums) {

        int l = nums.length;

        int[] jumps = new int[l];
        jumps[l-1] = 0;
        for(int i=l-2;i>=0;i--){
            int min = 10000;

            for(int j=i+1;j<i+nums[i]+1 && j<l;j++){
                min = Math.min(jumps[j],min);
            }
            jumps[i] = min+1;
            System.out.println(jumps[i]);
        }

        return jumps[0];

        
        
    }
}