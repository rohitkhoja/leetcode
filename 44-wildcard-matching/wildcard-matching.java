class Solution {
    public boolean isMatch(String s, String p) {
        int l = s.length();
        int pl = p.length();

        boolean[][] dp = new boolean[l+1][pl+1];
        dp[0][0] = true;
        for(int i=0;i<pl;i++){
            dp[0][i+1] = dp[0][i] && p.charAt(i)=='*';
        }
        for(int i=0;i<l;i++){
            dp[i+1][0] = false;
        }
        for(int i=1;i<=pl;i++){
            for(int j=1;j<=l;j++){
                if(p.charAt(i-1)=='*'){
                   dp[j][i] = dp[j-1][i] || dp[j][i-1] || dp[j-1][i-1];
                }
                else if(p.charAt(i-1)=='?'){
                    dp[j][i] = dp[j-1][i-1];
                }
                else{
                    dp[j][i] = dp[j-1][i-1] && p.charAt(i-1)==s.charAt(j-1);
                }
            }
        }
        return dp[l][pl];

    }
}