class Solution {
    public int[] getNoZeroIntegers(int n) {

        for(int i=1;i<n;i++){
            if(checkNoZero(i) & checkNoZero(n-i)) return new int[] {i,n-i};
        }
        return null;
    }

    public boolean checkNoZero(int n){
        
        while(n>0){
            if(n%10==0) return false;
            n/=10;
        }
        return true;
    }
}