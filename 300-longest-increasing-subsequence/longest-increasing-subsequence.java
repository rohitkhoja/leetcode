class Solution {

    class Pair{
        int num;
        int count;

        public Pair(int num, int count){
            this.num = num;
            this.count = count;
        }
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.num, a.num));
        pq.add(new Pair(nums[n-1], 1));
        int result = 1;
        for(int i=n-2;i>=0;i--){
            List<Pair> list = new ArrayList<>();

            int count = 1;
            while(!pq.isEmpty() && pq.peek().num>nums[i]){
                Pair p = pq.poll();
                count = Math.max(count, p.count+1);
                result = Math.max(result, count);
                list.add(p);
            }
            //System.out.println(nums[i]+" .."+count);
            pq.add(new Pair(nums[i], count));
            for(Pair p: list)
                pq.add(p);
        }
        
        return result;
    }
}