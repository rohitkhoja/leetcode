class Solution {

    class Element{
        int num;
        int index;

        public Element(){};

        public Element(int num, int index){
            this.num = num;
            this.index = index;
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.num,a.num));
        int i=0;
        int[] result = new int[nums.length+1-k];
        while(pq.size()<k){
            pq.add(new Element(nums[i],i));
            i++;
        }
        result[0] = pq.peek().num;

        for(;i<nums.length;i++){
            pq.add(new Element(nums[i],i));
            while(pq.peek().index<=i-k) pq.poll();
            result[i+1-k] = pq.peek().num;
        }

        return result;
    }
}