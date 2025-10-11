class ExamTracker {
    Map<Integer, Integer> map;
    List<Integer> timeList;
    List<Integer> list;
    List<Long> psum;
    Map<Integer, List<Long>> startMap;

    public ExamTracker() {
        map = new HashMap<>();
        timeList = new ArrayList<>();
        psum = new ArrayList<>();
        list = new ArrayList<>();
        startMap = new HashMap<>();
    }
    
    public void record(int time, int score) {    
        int l = timeList.size();
        if(l==0) psum.add((long) score);
        else {
            long last = psum.get(l-1);
            last += (long) score;
            psum.add(last);
        }
        timeList.add(time);
        list.add(score);
        map.put(time,l);
        
    }
    
    public long totalScore(int startTime, int endTime) {
        int l = timeList.size();
        int i1=0;
        int i2 = 0;
        if(map.containsKey(startTime)) i1 = map.get(startTime);
        else i1 = binarySearch(startTime, 0, l-1);
        if(map.containsKey(endTime)) i2 = map.get(endTime);
        else i2 = binarySearch1(endTime, 0, l-1);
        if(i2<i1) return 0;
        if(i1==0) return psum.get(i2);
        else return psum.get(i2)-psum.get(i1-1);
       
    }

    public int binarySearch(int time, int i, int j){
        
        while(i<=j){
            int m = i + (j-i)/2;
            if(timeList.get(m)==time) return m;
            else if(timeList.get(m)<time) i = m+1;
            else j = m-1;
        }
        return i;  
    }
    
    public int binarySearch1(int time, int i, int j){
        while(i<=j){
            int m = i + (j-i)/2;
            if(timeList.get(m)==time) return m;
            else if(timeList.get(m)<time) i = m+1;
            else j = m-1;
        }
        return i-1;
        
    }
}

// [1, 3, 5, 7, 13, 15, 16, 17]
/**
 * Your ExamTracker object will be instantiated and called as such:
 * ExamTracker obj = new ExamTracker();
 * obj.record(time,score);
 * long param_2 = obj.totalScore(startTime,endTime);
 */