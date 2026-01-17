class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        
        long maxSum = (long) n * (n+1) / 2;
        if(Math.abs(target) > maxSum) return new int[0];

        if((maxSum - target)%2!=0) return new int[0];

        long sum = (maxSum - target) / 2;
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for(int i=n;i>0;i--){
            if(sum==0) break;
            if(i>sum){
               set.add((int) sum);
               result.add((int) -sum);
               sum = 0;
               break;
            }

            else{
               set.add(i);
               result.add(-i);
               sum -= i;
            }
        }

        if(sum!=0) return new int[0];
        
        for(int i=1;i<=n;i++){
            if(!set.contains(i)){
                result.add(i);
            }
        }

        int[] rs = new int[n];
        for(int i=0;i<n;i++)
            rs[i] = result.get(i);

        return rs;    
    }
}