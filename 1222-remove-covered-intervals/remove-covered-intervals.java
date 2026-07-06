class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> {
            if(a[0]==b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0],b[0]);
        });

        int l = intervals.length;
        int ans = 0;

        for(int i=0;i<l;i++){
            ans++;
            int end = intervals[i][1];

            while(i+1<l && end>=intervals[i+1][1]) i++;

        }

        return ans;
    }
}