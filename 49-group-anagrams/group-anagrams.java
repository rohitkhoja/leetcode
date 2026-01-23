class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] chArray = str.toCharArray();
            Arrays.sort(chArray);
            
            String s = new String(chArray);
            int hashCode = s.hashCode();
            map.computeIfAbsent(hashCode, k-> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}