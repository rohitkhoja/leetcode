class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(char ch:s.toCharArray()){
            sMap.put(ch,sMap.getOrDefault(ch,0)+1);
        }
        for(char ch:t.toCharArray()){
            tMap.put(ch, tMap.getOrDefault(ch,0)+1);
        }

        if(sMap.size()!=tMap.size()) return false;
        for(char ch: sMap.keySet()){
            int l1 = sMap.get(ch);
            int l2 = tMap.getOrDefault(ch,0);
            if(l1!=l2) {
                return false;
            }
        }

        return true;
        
    }
}