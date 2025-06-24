class Solution {
    public boolean isIsomorphic(String s, String t) {

        if(s.length()!=t.length()) return false;

        int n = s.length();
        Map<Character, Set<Integer>> sMap = new HashMap<>();
        Map<Character, Set<Integer>> tMap = new HashMap<>();
        for( int i=0;i<n;i++){
            char ch = s.charAt(i);
            char ch1 = t.charAt(i);
            if(sMap.containsKey(ch) && !sMap.get(ch).equals(tMap.getOrDefault(ch1, new HashSet<>()))) return false;
            if(tMap.containsKey(ch1) && !tMap.get(ch1).equals(sMap.getOrDefault(ch, new HashSet<>()))) return false;
            
            sMap.computeIfAbsent(ch, k-> new HashSet<>()).add(i);
            tMap.computeIfAbsent(ch1, k-> new HashSet<>()).add(i);


            // sMap.put(ch, sMap.getOrDefault(ch,new HashSet<>()).add(i));
            // tMap.put(ch1, tMap.getOrDefault(ch,new HashSet<>()).add(i));

        }
        return true;

    
    }
}