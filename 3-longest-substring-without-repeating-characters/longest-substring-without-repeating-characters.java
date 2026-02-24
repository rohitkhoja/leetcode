class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> s1 = new HashMap<>();
        int result =0;
        
        int j=0;
        for(int i=0;i<s.length();i++){
            if(s1.containsKey(s.charAt(i)))
                j=Math.max(j,s1.get(s.charAt(i))+1);
            s1.put(s.charAt(i),i);
            result = Math.max(result, i-j+1);
        }
        return result;
    }
}
