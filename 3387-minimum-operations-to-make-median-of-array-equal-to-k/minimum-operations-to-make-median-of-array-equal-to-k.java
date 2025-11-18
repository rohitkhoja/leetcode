class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        //if(n==2) return Math.abs(k-nums[1]);
        int mid = n/2;
        long sum=0;
        
        if(nums[mid]>k){
            
            while(mid>=0 && nums[mid]>k){
                sum += Math.abs(nums[mid]-k);
                mid--;
            }
            return sum;
        }
        else {
            while(mid<n && nums[mid]<k){
                sum += Math.abs(nums[mid]-k);
                mid++;
            }
            return sum;
        }
        // ;

    }

    // public int binarySearch(int[] nums, int target, int start, int end, int m){
    //     if(start>end) {
    //         if(end<0) return start;
    //         // System.out.println(start+" start");
    //         // System.out.println(end+" end");
    //         if(start>=nums.length) return end;
    //         if(nums[start]>target && start<=m) return start;
    //         else return end;
    //     }

    //     int mid = (start+end)/2;
    //     if(nums[mid]>target) return binarySearch(nums, target, start, mid-1, m);
    //     else return binarySearch(nums, target, mid+1, end, m);
    // }
}