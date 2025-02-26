class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i=0;
        int j=n-1;
        int result = 0;
        while(i<j){
           result = Math.max(result, (j-i)*Math.min(height[i],height[j]));
           if(height[i]>height[j]) j--;
           else i++;
        }
        return result;
    }
}