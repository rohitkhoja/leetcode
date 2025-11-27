class Solution {
    

    class Pair{
        int sum;
        int index;
        public Pair(int sum, int index){
            this.sum = sum;
            this.index = index;
        }
    }

    public int maxResult(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.sum, a.sum));

        int n = nums.length;
        pq.add(new Pair(nums[0],0));

        // for(int i=1;i<=k;i++){
        //     int sum = nums[i];
        //     if(pq.peek().sum > sum){
        //         sum += pq.peek().sum;
        //     }
        //     pq.add(new Pair(sum, i));
        // }
        
        for(int i=1;i<n;i++){
            int sum = nums[i];
            while(!pq.isEmpty() && pq.peek().index+k<i){
                pq.poll();
            }
            sum += pq.peek().sum;
            pq.add(new Pair(sum, i));
        }

        while(!pq.isEmpty() && pq.peek().index!=n-1){
            pq.poll();
        }
        return pq.peek().sum;
    }
}