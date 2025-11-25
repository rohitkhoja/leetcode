class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        
        int n = s.length();
        if(n==0) return true;
        boolean[] isPossible = new boolean[n+1];
        isPossible[n] = true;
        StringBuilder sb = new StringBuilder();

        for(int i=n-1;i>=0;i--){
            for( String word: wordDict){
                int size = word.length();
                if(i+size<=n && s.substring(i,i+size).equals(word) && isPossible[i+size]){
                    isPossible[i] = true;
                    break;
                }
            }
        }

        
        return isPossible[0];
    }
}

