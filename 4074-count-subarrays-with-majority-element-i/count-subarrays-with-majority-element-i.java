class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {

        int result = 0;

        int count = 0;
        for(int i=0;i<nums.length;i++){
            count=0;
            for(int j=i;j<nums.length;j++){
                if(nums[j]==target) count++;
                if(count > (j-i+1)/2){
                    //System.out.println(i+".."+j);
                    //System.out.println(count);
                    result++;
                } 
            }
        }
        
        return result;
            
        
    }
}