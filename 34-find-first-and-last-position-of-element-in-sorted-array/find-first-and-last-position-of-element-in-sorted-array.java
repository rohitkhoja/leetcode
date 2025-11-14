class Solution {
    public int[] searchRange(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }

    public int[] binarySearch(int[] nums, int target, int start, int end){
        if(start>end) return new int[]{-1,-1};
        int mid = (start+end)/2;
        int l=-1;
        int r=-1;

        if(nums[mid]==target){
            int[] left = binarySearch(nums, target, start, mid-1);
            int[] right = binarySearch(nums, target, mid+1, end); 
            if(left[0]!=-1 && right[1]!=-1){
                return new int[]{left[0], right[1]};
            }
            else if(left[0]!=-1){
                return new int[]{left[0], mid};
            }
            else if(right[1]!=-1){
                return new int[]{mid, right[1]};
            }
            else return new int[]{mid, mid};
        }

        else if(nums[mid]>target){
            return binarySearch(nums, target, start, mid-1);
        }

        else{
            return  binarySearch(nums, target, mid+1, end); 
        }

    }
}