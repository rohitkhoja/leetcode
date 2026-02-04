class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int l1 = nums1.length;
        int l2 = nums2.length;
        int start = 0;
        int end = l1;

        while(start<=end){
            int mid1 = (start+end)/2;
            int mid2 = (l1+l2+1)/2 - mid1;
            int leftMaxA, leftMaxB, rightMinA, rightMinB;

            if(mid1==0) leftMaxA = Integer.MIN_VALUE;
            else leftMaxA = nums1[mid1-1];
            if(mid1==l1) rightMinA = Integer.MAX_VALUE;
            else rightMinA = nums1[mid1];
            if(mid2==0) leftMaxB = Integer.MIN_VALUE;
            else leftMaxB = nums2[mid2-1];
            if(mid2==l2) rightMinB = Integer.MAX_VALUE;
            else rightMinB = nums2[mid2];

            if(leftMaxA>rightMinB) end = mid1-1;
            else if(leftMaxB>rightMinA) start = mid1+1;
            else {
                if((l1+l2)%2==0){
                    return (double) (Math.max(leftMaxA,leftMaxB)+Math.min(rightMinB, rightMinA))/2;
                }
                else return (double) Math.max(leftMaxA,leftMaxB);
            }
        }
        return 0;
        
    }
}