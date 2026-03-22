class Solution {
    public int longestSubarray(int[] nums, int limit) {

        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();

        int result = 0;
        int j=0;

        for(int i=0;i<nums.length;i++){

            int n = nums[i];
            while(!minQ.isEmpty() && nums[minQ.getLast()]>n) minQ.removeLast();
            minQ.add(i);

            while(!maxQ.isEmpty() && nums[maxQ.getLast()]<n) maxQ.removeLast();
            maxQ.add(i);

            while(!minQ.isEmpty() && !maxQ.isEmpty()  && nums[maxQ.peekFirst()]-nums[minQ.peekFirst()]>limit){
                if(maxQ.peekFirst()==j) maxQ.removeFirst();
                if(minQ.peekFirst()==j) minQ.removeFirst();
                j++;
            }

            result = Math.max(result, i-j+1);

        }

        return result;
        
    }
}