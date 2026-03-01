class Solution {
    public int findContentChildren(int[] g, int[] s) {
        
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        int j=0;
        int n = g.length;
        for(int i=0; i<s.length && j<n;i++){
            if(s[i]>=g[j]){
                result++;
                j++;
            }
        }

        return result;
    }
}