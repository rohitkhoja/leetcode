class Solution {
    
    
    public long minMoves(int[] balance) {
        
        
        int n = balance.length;
        long result = 0;
        int index = n+1;
        long sum = 0;
        for(int i=0;i<n;i++){
            sum += balance[i];
            if(balance[i]<0){
                index = i;
            }
        }
        System.out.println(index+" index "+ n );
        if(sum<0) return -1;
        if(index>n) return 0;

        sum = -balance[index];

        int i = index-1;
        int j = index+1;

        while(i>=0 && j<n){
            long balanceLandR = balance[i]+balance[j];
            if(balanceLandR>=sum){
                result += (index-i) * sum;
                sum = 0;
                break;
            }
            else {
                sum -= balanceLandR;
                result += (index-i) * balanceLandR;
            }
            i--;
            j++;
        }
        if(sum==0) return result;

        if(i<0){
            i = n-1;
        }
        else j = 0;

        while(i>j){
            long balanceLandR = balance[i]+balance[j];
            
            if(balanceLandR>=sum){
                result += Math.min(Math.abs(index-i),Math.abs(index-j)) * sum;
                //System.out.println(result);
                sum = 0;
                break;
            }
            else {
                sum -= balanceLandR;
                result += Math.min(Math.abs(index-i),Math.abs(index-j)) * balanceLandR;
            }
            i--;
            j++;
        }
        if(sum==0) return result;
        if(i==j && balance[i]<sum) return -1;
        else {
            result += Math.abs(index-i) * sum;
        }
        return result;


    
        
    }
}