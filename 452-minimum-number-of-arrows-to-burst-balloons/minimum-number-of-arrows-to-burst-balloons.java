class Solution {
    public int findMinArrowShots(int[][] points) {
        int result = 0;
        int l = points.length;

        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        for(int i=0; i<l;){
            int xEnd = points[i][1];
            int startIndex = i;
            while(i<l && points[i][0]<=xEnd)
                i++;
            result++;   
        }
        return result;
        
    }
}