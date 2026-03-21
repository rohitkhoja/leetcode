class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1;i<heights.length;i++){
            if(heights[i]>heights[i-1]) pq.add(heights[i]-heights[i-1]);
            if(pq.size()>ladders){
                if(pq.peek()>bricks) return i-1;
                int h = pq.poll();
                bricks -=h;
            }
        }
        return heights.length-1;
        
    }
}