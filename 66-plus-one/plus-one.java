class Solution {
    public int[] plusOne(int[] digits) {
        if(digits[digits.length-1]!=9){
            digits[digits.length-1] += 1;
            return digits;
        }

        int n = digits.length-1;

        while(n>=0 && digits[n]==9){
            digits[n]=0;
            n--;
        }
        if(n!=-1){
            digits[n] += 1;
            return digits;
        }
        int[] result = new int[digits.length+1];
        result[0]=1;
        int i=1;
        while(i<digits.length+1){
            result[i]=0;
            i++;
        }
        return result;
        
    }
}