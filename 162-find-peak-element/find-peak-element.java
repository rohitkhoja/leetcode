class Solution {
    public int findPeakElement(int[] nums) {
        int n  = nums.length;
        if(n==1) return 0;
        if(nums[0]> nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;
        return binarySearch(nums, 0, n-1);
    }

    public int binarySearch(int[] nums, int start, int end){
        if(start>end) return -1;
        int mid = (start+end)/2;
        if(mid+1<nums.length && mid-1 >=0 && 
            nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]) 
                return mid;

        int left = binarySearch(nums, start, mid-1);
        if(left!=-1) return left;
        int right  = binarySearch(nums, mid+1, end);
        if(right!=-1) return right;
        return -1;

    }
}