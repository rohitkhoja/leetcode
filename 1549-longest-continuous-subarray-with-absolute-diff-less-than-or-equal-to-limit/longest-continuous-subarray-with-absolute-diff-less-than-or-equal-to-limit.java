class Solution {
    class Pair{
        int value;
        int index;

        public Pair(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.value, b.value));
        PriorityQueue<Pair> pq1 = new PriorityQueue<>((a,b) -> Integer.compare(b.value, a.value));
        int n = nums.length;
       
        int result = 1;
        Pair p = new Pair(nums[0],0);
        pq.add(p);
        pq1.add(p);
        int j=0;
        for(int i=1;i<n;i++){
            p = new Pair(nums[i],i);
            pq.add(p);
            pq1.add(p);
            if(pq1.peek().value-pq.peek().value>limit){
                int temp = j;
                while(pq1.peek().value-pq.peek().value>limit){
                    while(pq.peek().index<=temp) pq.poll();
                    while(pq1.peek().index<=temp) pq1.poll();
                    temp++;
                }
                j = temp;
                // pq.clear();
                // pq1.clear();
                // while(temp<=i){
                //     p = new Pair(nums[temp], temp);
                //     pq.add(p);
                //     pq1.add(p);
                //     temp++;
                // }
            }
            result = Math.max(result, i-j+1);

        }
        return result;
    }
}