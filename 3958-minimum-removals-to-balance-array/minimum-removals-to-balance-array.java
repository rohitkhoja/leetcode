class Solution {
    public int minRemoval(int[] nums, int k) {

        Arrays.sort(nums);
        int n = nums.length;
        int result = n+1;
        for(int i=0;i<n;i++){
            long target = (long) nums[i]*k;
            int start = 0;
            int end = n-1;

            while(start<end){
                int mid = (start+end)/2;
                if(nums[mid]>target) {
                    end = mid-1;
                }
                else if(nums[mid]<target){
                    start = mid+1;
                }
                else{
                    while(mid+1<n && nums[mid]==nums[mid+1]) mid++;
                    start=mid;
                    break;
                }
            }
            if(start==n) result = Math.min(result, n-i);
            else if(nums[start]>target) result = Math.min(result, n-(start-i));
            else if(start+1<n && nums[start+1]<=target) result = Math.min(result, n-(start+2-i));
            else result = Math.min(result, n-(start+1-i));

        }

        return result;

        
    }


}