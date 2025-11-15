class Solution {

    class Object {
        int profit;
        int capital;

        public Object(int profit, int capital){
            this.profit = profit;
            this.capital = capital;
        }

    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Object[] objects = new Object[n];
        
        PriorityQueue<Object> pq = new PriorityQueue<>( 
            (a,b) ->  Integer.compare(b.profit, a.profit));

        for(int i=0;i<n;i++){
            objects[i] = new Object(profits[i], capital[i]);
        }

        Arrays.sort(objects, (a,b) -> Integer.compare(a.capital, b.capital));

        
        for(int i=0, j=0;i<k;i++){
            
            while(j<n && objects[j].capital<=w){
                pq.add(objects[j]);
                j++;
                //System.out.println(j+"..");
            }
            if(pq.isEmpty()) return w;
            
            Object ob = pq.poll();
            //System.out.println(ob.profit+"vv"+ob.capital);
            //System.out.println(pq.size()+"sz");
            w += ob.profit;
            //System.out.println(w);
        }  

        return w;
        
    }
}