class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        int[] right = new int[n];
        int[] left = new int[n];
        left[0] = height[0];
        
        for(int i=1;i<n-1;i++){
            left[i] = Math.max(height[i-1],left[i-1]);
        }
        right[n-1] = height[n-1];
        for(int i=n-2;i>0;i--){
            right[i] = Math.max(height[i+1],right[i+1]);
            
        }

        int result = 0;

        for(int i=0;i<n-1;i++){
            int w = Math.min(left[i],right[i])-height[i];
            result += w>0? w: 0;
        }

        return result;
        
    }
}