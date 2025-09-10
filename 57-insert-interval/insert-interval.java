class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int l = intervals.length;
        if(l==0){
            int[][] newInt = new int[1][2];
            newInt[0] = newInterval;
            return newInt;
        }
        int startKey = newInterval[0];
        int endKey = newInterval[1];
        int startIndex = binarySearch(intervals, startKey, 0, l-1);
        //System.out.println(startIndex);
        int endIndex = binarySearch(intervals, endKey, 0, l-1);
        //System.out.println(endIndex);
        
        if(startIndex==endIndex){
            int index = startIndex;
            if(index==-1)  index++;

            if(startKey > intervals[index][1] || endKey < intervals[index][0]){
                int[][] newIntervals = new int[l+1][2];
                for(int i=0,j=0;i<l+1;i++){
                    if(i==startIndex+1) newIntervals[i] = newInterval;
                    else {
                       newIntervals[i] = intervals[j];
                       j++; 
                    }
                }
                return newIntervals;
            }
            else if(endKey <= intervals[startIndex][1]){
                return intervals;
            }
            else {
                intervals[startIndex][1] = endKey;
                return intervals;
            }
        }
        else{
            if(endKey < intervals[endIndex][1]) endKey = intervals[endIndex][1];
            if(startIndex!=-1 && startKey >= intervals[startIndex][0] && startKey <= intervals[startIndex][1]){
                startKey = intervals[startIndex][0];
            }
            else startIndex++;
            int[][] newIntervals = new int[l-(endIndex-startIndex)][2];
            for(int i=0,j=0;j<l;i++){
                if(i==startIndex){
                    int[] newInt = new int[] {startKey, endKey};
                    newIntervals[i] = newInt;
                    j=endIndex+1;
                }
                else {
                    newIntervals[i] = intervals[j];
                    j++; 
                }
            }
            return newIntervals;
        }
          
    }

    public int binarySearch(int[][] intervals, int key, int i, int j){
        
        if(i>j) return j;
        int m = (i+j)/2;
        int direction = check(intervals[m],key);
        if(direction==0) return m; 
        else if(direction==1) return binarySearch(intervals, key, m+1, j);
        else return binarySearch(intervals, key,  i,  m-1);

    }

    public int check(int[] interval, int key){
        if(key>=interval[0] && key<=interval[1]) return 0;
        else if(key>interval[1]) return 1;
        else return -1;
    }
     

    
}