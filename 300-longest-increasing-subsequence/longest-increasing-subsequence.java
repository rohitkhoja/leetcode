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
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.num, b.num));
        pq.add(new Pair(nums[0], 1));
        int result = 0;
        for(int i=1;i<n;i++){
            List<Pair> list = new ArrayList<>();

            int count = 1;
            while(!pq.isEmpty() && pq.peek().num<nums[i]){
                Pair p = pq.poll();
                count = Math.max(count, p.count+1);
                list.add(p);
            }
            //System.out.println(nums[i]+" .."+count);
            pq.add(new Pair(nums[i], count));
            for(Pair p: list)
                pq.add(p);
        }
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            result = Math.max(result, p.count);
        }
        return result;
    }
}