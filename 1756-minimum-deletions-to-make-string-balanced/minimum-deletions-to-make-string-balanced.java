class Solution {
    public int minimumDeletions(String s) {

        int b=0;
        int result = 0;

        for(char c: s.toCharArray()){
            if(c=='b') b++;
            else{
                result = Math.min(result+1, b);
            }
        }
        return result;
        
    }

}