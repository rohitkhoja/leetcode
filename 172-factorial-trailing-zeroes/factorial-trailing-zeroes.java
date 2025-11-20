class Solution {
    public int trailingZeroes(int n) {
        int result = 0;
        while(n>0){
            if(n%5==0){
                int temp = n;
                while(temp%5==0){
                    temp /= 5;
                    result ++;
                }
            }
            n--;
        }

        return result;
    }
}