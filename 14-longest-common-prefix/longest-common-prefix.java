class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int l = Integer.MAX_VALUE;
        for(int i=0;i<strs.length;i++){
            l = Math.min(l,strs[i].length());
        }

        for(int i=0;i<l;i++){
            char ch = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)!=ch) return sb.toString();
            }
            sb.append(ch);
        }

        return sb.toString(); 
    }
}