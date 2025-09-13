class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int discarded = 0;
        for(int i=0;i<arrivals.length;i++){
            int arrival = arrivals[i];
            if(i>=w){
                int index = i-w;
                if(!set.contains(index)){
                    int arrLast = arrivals[index];
                    int n = map.get(arrLast);
                    map.put(arrLast,n-1); 
                }  
            }
            int n = map.getOrDefault(arrival,0);
            if(n>=m){
               discarded++; 
               set.add(i); 
            } 
            else {
                map.put(arrival,n+1);
            }
            
            
        }
        return discarded;
        
    }
}