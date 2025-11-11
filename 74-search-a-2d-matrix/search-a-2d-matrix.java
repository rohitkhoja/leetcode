class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] rows = new int[matrix.length];
        for(int i=0;i<matrix.length;i++)
            rows[i] = matrix[i][0];
        int row = binarySearch(rows, target, 0, matrix.length-1);
        return matrix[row][binarySearch(matrix[row], target, 0, matrix[0].length-1)] == target;
    }

    public int binarySearch(int[] nums, int target, int start, int end){
        if(start>end) {
            if(end>=0 && end<nums.length) return end;
            else return start;
        }
        int mid = (start+end)/2;
        
        if(target==nums[mid]) return mid;
        else if(target>nums[mid]) return binarySearch(nums, target, mid+1, end);
        else return binarySearch(nums, target, start, mid-1);
        
    }
}