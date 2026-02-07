class Solution {
    public int minimumDeletions(String s) {

        int b=0;
        int result = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='b') b++;
            else{
                result = Math.min(result+1, b);
            }
        }
        return result;
        
    }

}