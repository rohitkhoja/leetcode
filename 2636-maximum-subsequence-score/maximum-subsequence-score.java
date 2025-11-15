class Solution {

    class Object implements Comparable<Object>{
        int num1;
        int num2;

        public Object(int num1, int num2){
            this.num1 = num1;
            this.num2 = num2;
        }

        @Override
        public int compareTo(Object other){
            return Integer.compare(other.num2, this.num2);
        }
    }

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Object[] objects = new Object[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            objects[i] = new Object(nums1[i], nums2[i]);
        }

        Arrays.sort(objects);

        
        long sum = 0;
        long result = 0;
        for(int i=0;i<n;i++){
            if(i<k){
                sum += objects[i].num1;
                pq.add(objects[i].num1);
                if(i==k-1){
                    result = sum * (long) objects[i].num2;
                }
            }
            else{
                
                int rm = pq.poll();
                sum -= rm;
                sum += objects[i].num1;
                pq.add(objects[i].num1);

                result = Math.max(result, sum * (long) objects[i].num2);
            }
            
        }

        return result;

        
    }
}