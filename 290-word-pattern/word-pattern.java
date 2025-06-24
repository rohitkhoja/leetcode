class Solution {
    public boolean wordPattern(String pattern, String s) {

        Map<Character, Set<Integer>> patternMap = new HashMap<>();
        Map<String, Set<Integer>> sMap = new HashMap<>();
        
        String[] parts = s.split(" ");
        int n = pattern.length();
        // for(String s1:parts) System.out.println(s1);
        if(n!=parts.length) return false;
        for(int i=0;i<n;i++){
            char ch = pattern.charAt(i);
            String part = parts[i];
            if(patternMap.containsKey(ch) && !patternMap.get(ch).equals(sMap.getOrDefault(part, 
                                                new HashSet<>()))) return false;
            if(sMap.containsKey(part) && !sMap.get(part).equals(patternMap.getOrDefault(ch, 
                                                new HashSet<>()))) return false;

            patternMap.computeIfAbsent(ch, k-> new HashSet<>()).add(i);
            sMap.computeIfAbsent(part, k-> new HashSet<>()).add(i);
        }

        return true;
        
        
    }
}