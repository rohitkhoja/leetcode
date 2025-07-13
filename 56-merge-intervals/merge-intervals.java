class Solution {
    public int[][] merge(int[][] intervals) {
      Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
      int n = intervals.length;
      List<int[]> result = new ArrayList<>();
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
        result.add(new int[]{start,end});
        start = -1;
        i--;
        j++;
      }
      
      return result.toArray(new int[result.size()][]);

        
    }
}
