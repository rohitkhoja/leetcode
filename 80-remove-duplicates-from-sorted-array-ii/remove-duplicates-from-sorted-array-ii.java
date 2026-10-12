class Solution {
    public int removeDuplicates(int[] nums) {

        int l = nums.length;
        int k = 0;
        
        for(int i=0;i<l;i++){
            nums[k] = nums[i];
            k++;

            if(i+1<l && nums[i]==nums[i+1]){
                nums[k] = nums[i+1];
                k++;
                i++;
            }
            while(i+1<l && nums[i]==nums[i+1]) i++;
        }

        return k;
        
    }
}