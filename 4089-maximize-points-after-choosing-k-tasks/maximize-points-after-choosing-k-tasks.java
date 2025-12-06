class Solution {

    class Pair{
        int num;
        int index;
        public Pair(int num, int index){
            this.num = num;
            this.index = index;
        }
    }
    public long maxPoints(int[] technique1, int[] technique2, int k) {

        int n = technique1.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.num, b.num));
        
        int count = 0;
        for(int i=0;i<n;i++){
            if(technique1[i]>technique2[i]) count++;
            else{
                pq.add(new Pair(technique2[i]-technique1[i], i));
            }
        }
        long result = 0;
        int diff = k-count;
        Set<Integer> set = new HashSet<>();

        while(diff>0){
            Pair p = pq.poll();
            set.add(p.index);
            result += technique1[p.index];
            diff--;
        }

        for(int i=0;i<n;i++){
            if(set.contains(i)) continue;

            result += Math.max(technique1[i], technique2[i]);

        }

        return result;
        
    }
}

