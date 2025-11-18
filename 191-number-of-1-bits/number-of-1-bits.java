class Solution {
    public int hammingWeight(int n) {
        int i=32;
        int result=0;
        while(i>0){
            int temp=0;
            temp |= n&1;
            if(temp>0) result++;
            n>>>=1;
            i--;
        }
        return result;
    }
}