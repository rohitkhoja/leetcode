class Solution {
    public int peakIndexInMountainArray(int[] arr) {
       return binarySearch(arr, 0, arr.length-1);
    }

    public int binarySearch(int[] nums, int start, int end){
        if(start>end) return -1;
        int mid = (start+end)/2;
        if((mid+1)<nums.length && (mid-1)>=0 && 
            nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]) return mid;
        int right = binarySearch(nums, mid+1, end);
        if(right!=-1) return right;
        int left = binarySearch(nums, start, mid-1);
        if(left!=-1) return left;
        return -1;
    }
}