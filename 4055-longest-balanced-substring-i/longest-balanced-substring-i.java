class Solution {
    public int longestBalanced(String s) {
        
        int number = 0;
        int startIndex = 0;
        int max = 1;
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            Map<Character, Integer> map = new HashMap<>();
            char ch = chars[i];
            map.put(ch,1);
            for(int j=i+1;j<chars.length;j++){
                char ch1 = chars[j];
                if(map.containsKey(ch1)){
                    int c = map.get(ch1);
                    map.put(ch1,c+1);
                }
                else map.put(ch1,1);
                if(isBalanced(map)) max = Math.max(max, j-i+1);
            }
        }
        return max;
        
    }
    public boolean isBalanced(Map<Character, Integer> map){
        
        int c = 0;
        for(int i: map.values()){
            if(c==0) c=i;
            else{
                if(i!=c) return false;
            }
        }
        return true;
    }
}