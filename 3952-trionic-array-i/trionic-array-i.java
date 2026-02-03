class Solution {
    public boolean isTrionic(int[] nums) {

        int n = nums.length;
        boolean p = false;
        boolean q = false;
        if(nums[0]>=nums[1]) return false;
        for(int i=1;i<n-1;i++){
            if(!p){
                if(nums[i]>nums[i+1]){
                    p = true;
                    //System.out.println("fw");
                }
                if(nums[i]==nums[i+1])return false;
            }
            else if(!q){
                if(nums[i]<nums[i+1]) {
                   q = true;
                   //System.out.println("fw");
                }
                if(nums[i]==nums[i+1])return false;
            }
            else{
                if(nums[i]>=nums[i+1]) return false;
            }
        }
        
        return p&q;
        
    }
}