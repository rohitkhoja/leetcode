class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer,List<String>> map = new HashMap<>();
        int n = strs.length;
        for(int i=0;i<n;i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            int hash = s.hashCode();
            map.computeIfAbsent(hash, k-> new ArrayList<>()).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}


// first sort, get hash values
// 1,2,1,3,4,5
// hash value as key and keep on adding them to mpa and return them 