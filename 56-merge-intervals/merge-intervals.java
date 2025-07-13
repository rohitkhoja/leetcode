class Solution {
    public int[][] merge(int[][] intervals) {
      Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
      int n = intervals.length;
      int[][] result = new int[n][2];
      int j=0;
      int start = -1;
      int end = 0;

      for(int i=0;i<n;i++){
        if(start==-1){
            start = intervals[i][0];
            end = intervals[i][1];
            i++;
        }
        while(i<n && intervals[i][0]<=end){
            end = Math.max(end,intervals[i][1]);
            i++;
        }
        result[j] = new int[]{start,end};
        start = -1;
        i--;
        j++;
      }
      int[][] result1 = new int[j][2];
      for(int i=0;i<j;i++){
        result1[i] = result[i];
      }
      return result1;

        
    }
}
