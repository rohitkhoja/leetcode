class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {

        
        int j = heights.length;
        int i = 0;
        int result =0;
        while(i<j){
            int mid = (i+j)/2;

            int tempBricks = bricks;
            int temLadders = ladders;
            
            PriorityQueue<Integer> q = new PriorityQueue<>();
            for(int q1=1;q1<=mid;q1++){
                if(heights[q1]>heights[q1-1]) q.add(heights[q1]-heights[q1-1]);
            }
            while(!q.isEmpty() && tempBricks>=q.peek()){
                tempBricks -= q.peek();
                q.poll();
            }
            while(!q.isEmpty() && temLadders>0) {
                q.poll();
                temLadders--;
            }

            if(q.isEmpty()) {
                result = mid;
                i = mid+1;
            }
            else j=mid;
        }
        return result;
        
    }
}