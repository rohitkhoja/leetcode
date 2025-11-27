class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String result = ""+s.charAt(0);
        for(int i=0;i<n-1;i++){
            int j=i-1, k=i+1;
            while(j>=0 && k<n && s.charAt(j)==s.charAt(k)){
                j--;
                k++;
            }
            
            j++;
            if(result.length()<k+1-j){
                //System.out.println(k+" ."+j);
                result = s.substring(j,k);
            }
                

            j=i;
            k=i+1;   
            while(j>=0 && k<n && s.charAt(j)==s.charAt(k)){
                j--;
                k++;
            }
            
            j++;
            if(result.length()<k+1-j){
                //System.out.println(k+" ."+j);
                result = s.substring(j,k);
            }
                

        }
        return result;
    }
}