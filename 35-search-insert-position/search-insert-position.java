class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0 , nums.length-1);
    }

    public int binarySearch(int[] nums, int target, int start, int end){
        if(start>end) return start;
        int mid = (start+end)/2;
        //System.out.println(mid);
        if(target == nums[mid]) return mid;
        else if(target > nums[mid]) return binarySearch(nums, target, mid+1, end);
        else return binarySearch(nums, target, start, mid-1);
        
    }
}
