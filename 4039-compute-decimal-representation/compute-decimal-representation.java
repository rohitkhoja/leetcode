class Solution {
    public int[] decimalRepresentation(int n) {
        int i = 0;
        List<Integer> digits = new ArrayList<>();
        while(n>0){
            int digit = n%10;
            if(digit>0)
                digits.add((int)(digit*Math.pow(10,i)));
            n=n/10;
            i++;
        }
        int[] result = new int[digits.size()];
        for(int j=0;j<digits.size();j++)
            result[j] = digits.get(digits.size()-j-1);

        return result;
        
        
    }
}