class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int h = nums.length-1;
        
        for(int i=0;i<nums.length && i<=h;i++){
            
            if(nums[i]==0){
                nums[i]=nums[l];
                nums[l]=0;
                l++;
            }

            if(nums[i]==2){
                nums[i] = nums[h];
                nums[h] = 2;
                h--;
                i--;
            }
        }
    }
}