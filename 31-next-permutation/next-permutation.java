class Solution {
    public void nextPermutation(int[] nums) {
        int l = nums.length;
        int i = l-2;
        for(;i>=0;i--){
            if(nums[i]<nums[i+1]){
                int temp = nums[i];
                int j=i+1;
                for(;j<l;j++){
                    if(nums[j]<=nums[i]) break;
                }
                nums[i] = nums[j-1];
                nums[j-1]  = temp;
                i++;
                for(j=l-1;i<j;i++,j--){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                break;
            }
        }
        if(i==-1){
            i=0;
            for(int j=l-1;i<j;j--,i++){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
}