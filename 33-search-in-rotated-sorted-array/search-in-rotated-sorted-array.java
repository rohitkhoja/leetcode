class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int index = binarySearch(nums, 0, n-1);
        //System.out.println(index);
        if(index==-1)
            return binarySearch2(nums, target, 0, n-1);
        else if(nums[index]==target) return index;
        else if(nums[n-1]==target) return n-1;
        else if(nums[n-1]>target && nums[index]<target)
            return binarySearch2(nums, target, index+1, n-2);
        else return binarySearch2(nums, target, 0, index-1);  
        //return -1; 

    }

    public int binarySearch(int[] nums, int start, int end){
        if(start>end) return -1;
        int mid = (start+end)/2;
        if(mid-1>=0  && nums[mid]<nums[mid-1]) return mid;
        int left = binarySearch(nums, start, mid-1);
        if(left!=-1) return left;
        int right = binarySearch(nums, mid+1, end);
        if(right!=-1) return right;  
        return -1;  
    }

    public int binarySearch2(int[] nums, int target, int start, int end){
        if(start>end) return -1;
        int mid = (start+end)/2;
        //System.out.println(mid);
        //System.out.println(nums[mid]+"..."+target);
        if(nums[mid]==target) return mid;
        else if(nums[mid]>target) return binarySearch2(nums, target, start, mid-1);
        else return binarySearch2(nums, target, mid+1, end);
    }
}