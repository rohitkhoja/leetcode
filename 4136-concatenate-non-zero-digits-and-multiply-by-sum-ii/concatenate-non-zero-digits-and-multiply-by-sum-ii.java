class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {

        int MOD = 1000000007;
        int n = s.length();
        int[] digits = new int[n];

        int[] pSum = new int[n];
        long[] nums = new long[n];
        int[] cd = new int[n];
        long[] pow = new long[n+1];
        pow[0] = 1;
        for(int i=1;i<n+1;i++){
            pow[i] = (pow[i-1]*10)%MOD;
        }
        for(int i=0;i<n;i++){
            digits[i] = s.charAt(i) - '0';
        }
        pSum[0] = digits[0];
        cd[0]=1;
        nums[0] = digits[0];
        
        
        for(int i=1;i<n;i++){
            pSum[i] = pSum[i-1]+digits[i];
            if(digits[i]!=0){
                cd[i] = cd[i-1]+1;
                nums[i] = ((nums[i-1]*10) + digits[i])%MOD;
                //System.out.println(nums[i]);
            }
            else {
                cd[i] = cd[i-1];
                nums[i] = (nums[i-1]);
            }
            
        }

        
        int[] result = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int i1 = queries[i][0];
            int i2 = queries[i][1];
            if(i1==0){
                //System.out.println(nums[i2] +" ss "+ pSum[i2]);
                result[i] =(int) ((long)nums[i2]*pSum[i2]%MOD);
            }
            else{
                // System.out.println(nums[i2]+" __"+nums[i1-1]+"__"+cd[i1-1]);
                // System.out.println(pSum[i2] +" ss "+ pSum[i1-1]);
                long num1 = (MOD +  nums[i2] - ((nums[i1-1]* pow[cd[i2]-cd[i1-1]])%MOD))%MOD;
                // System.out.println(((nums[i1-1]* pow[cd[i2]-cd[i1-1]])%MOD)+" ___");
                // System.out.println(nums[i2]+"__ ___");
                int sum1 = (pSum[i2] - pSum[i1-1]);
                result[i] = (int) ((num1*sum1)%MOD);
            }
        }

        return result;
        
        
    }
}