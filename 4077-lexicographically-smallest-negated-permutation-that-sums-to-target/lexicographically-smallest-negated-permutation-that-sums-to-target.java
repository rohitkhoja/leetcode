class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {

        List<Integer> ps = new ArrayList<>();
        Set<Integer> ng = new HashSet<>();

        long sum = ((long) n*(n+1))/2;
        if(Math.abs(target)>sum) return new int[0];
        if(Math.abs(sum-target)%2!=0) return new int[0];
        
        sum = (sum-target)/2;
        int temp = n;
        while(sum>0 && temp>=1){
           if(temp<=sum){
               sum -= temp;
               ng.add(temp);
           }
           temp--;
        }

        int[] result = new int[n];
        for(int i=0;i<n;i++){
            if(ng.contains(i+1))
                result[i] = -(i+1);
            else result[i] = i+1;
        }
        
        Arrays.sort(result);
        return result;
    }
}