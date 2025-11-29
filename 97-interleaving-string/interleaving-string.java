class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
       int l1 = s1.length();
       int l2 = s2.length();
       int l3 = s3.length();
       if(l3!=l1+l2) return false;
       boolean[][] dp = new boolean[l1+1][l2+1];
       dp[l1][l2] = true;
    //    int i = l1;
    //    int j = l2;

       for(int i=l1;i>=0;i--){
        for(int j=l2;j>=0;j--){
            if(i-1>=0 && dp[i][j] && s1.charAt(i-1)==s3.charAt(i+j-1)){
                dp[i-1][j] = true;
            }

            if(j-1>=0 && dp[i][j] && s2.charAt(j-1)==s3.charAt(i+j-1) ){
                dp[i][j-1] = true;
            }
        }
       }
       return dp[0][0];
    //    while(l3>0){
    //         if(i-1>=0 && s1.charAt(i-1)==s3.charAt(l3-1) && dp[i][j]){
    //             dp[i-1][j] = true;
    //             i--;
    //         }
            
    //         if(j-1>=0 && s2.charAt(j-1)==s3.charAt(l3-1) && dp[i][j]){
    //             dp[i][j-1] = true;
    //             j--;
    //         }
    //         else break;
    //         System.out.println(i+".."+j);
    //         l3--;
    //     }
    //     if(l3==0) return true;
    //     return false;

       
    }
}


//  a a b c c 
// 