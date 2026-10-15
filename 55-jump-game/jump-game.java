class Solution {
    public boolean canJump(int[] nums) {
        
        int l = nums.length;

        for(int i=0;i<l;i++){
            nums[i] +=i;
        }
        int max = nums[0];
        for(int i=1;i<l-1;i++){
            
            if(max<i) return false;
            
            max = Math.max(max,nums[i]);
            if(max>=l-1) return true;
        }

        return max>=l-1;



    }
}