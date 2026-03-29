class TimeMap {

    class values{
        int time;
        String value;
        public values(int time, String value){
            this.time = time;
            this.value = value;
        }
    }
    Map<String, List<values>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<values> list = map.getOrDefault(key, new ArrayList<>());
        list.add(new values(timestamp, value));
        map.put(key,list);
    }
    
    public String get(String key, int timestamp) {
        List<values> list = map.getOrDefault(key, new ArrayList<>());
        //System.out.println(list);
        if(list.size()==0 || timestamp<list.get(0).time) return "";

        int i=0;
        int j = list.size()-1;
        while(i<=j){
            int mid = (i+j)/2;

            if(list.get(mid).time==timestamp) return list.get(mid).value;
            else if(list.get(mid).time>timestamp) j=mid-1;
            else i=mid+1;
        }
        return list.get(j).value;
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */