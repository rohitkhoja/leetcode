class Solution {
    public int reverseBits(int n) {
        int result = 0;
        int i=32;
        while(i>0){
            result <<= 1;

            result |= (n&1);

            n >>>= 1;;
            i--;

        }

        return result;
    }
}