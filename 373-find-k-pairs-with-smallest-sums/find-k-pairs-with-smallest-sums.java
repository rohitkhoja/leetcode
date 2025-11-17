class Solution {

    class Pair{
        int sum;
        int i;
        int j;

        public Pair(int sum, int i, int j){
            this.sum = sum;
            this.i = i;
            this.j = j;

        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.sum, b.sum));

        

        List<List<Integer>> result = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        pq.add(new Pair(nums1[0]+nums2[0], 0, 0));
        set.add(0+" "+0);
        while(k>0 ){

            Pair p = pq.poll();
            result.add(new ArrayList<>(List.of(nums1[p.i], nums2[p.j])));

            if(p.i+1<n1 && !set.contains((p.i+1)+" "+p.j)) pq.add(new Pair(nums1[p.i+1]+nums2[p.j],p.i+1,p.j));
            set.add((p.i+1)+" "+p.j);
            //System.out.println((p.i+1)+""+p.j);
            if(p.j+1<n2&& !set.contains(p.i+" "+(p.j+1))) pq.add(new Pair(nums1[p.i]+nums2[p.j+1],p.i,p.j+1));
            set.add(p.i+" "+(p.j+1));
            //System.out.println(p.i+""+(p.j+1));
            k--;
            
            
        }
        return result;
    }
}