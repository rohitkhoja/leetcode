class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(nums[0]<nums[n-1]) return nums[0];
        return binarySearch(nums, 0, n-1);
    }

    public int binarySearch(int[] nums, int start, int end){
        if(start>end) return -1;

        int mid  = (start+end)/2;
        //System.out.println(mid);
        if(mid-1>=0 && nums[mid-1]>nums[mid]) return nums[mid];

        if(nums[mid]<nums[0]) {
            return binarySearch(nums, start, mid-1);
        }
        else {
            return binarySearch(nums, mid+1, end);
        }
    }
}