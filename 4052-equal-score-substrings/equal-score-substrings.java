class Solution {
    public boolean scoreBalance(String s) {
        int totalSum = 0;
        int sum1 = 0;
        for(char c: s.toCharArray()){
            totalSum += c - 'a' + 1; 
        }
        for(char c: s.toCharArray()){
            sum1 += c - 'a' + 1; 
            totalSum -= c - 'a' + 1; 
            if(sum1==totalSum) return true;
        }
        return false;
        
        
    }
}