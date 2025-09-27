class Solution {
    public String majorityFrequencyGroup(String s) {

        Map<Character,Integer> chars = new HashMap<>();
        Map<Integer,String> countMap = new HashMap<>();
        int maxSize = 0;
        int maxFreq = 0;
        String result = "";
        for(char c : s.toCharArray()){
            if(chars.containsKey(c)){
                int n = chars.get(c);
                chars.put(c,n+1);
            }
            else chars.put(c,1);
        }
        for(char c : chars.keySet()){
            int n = chars.get(c);
            String s1 = "";
            if(countMap.containsKey(n)){
                s1 = countMap.get(n);
                countMap.put(n,s1+String.valueOf(c));
                
            }
            else countMap.put(n,s1+String.valueOf(c));
            if(s1.length()+1>maxSize) {
                maxSize = s1.length()+1;
                maxFreq = n;
                result = s1+c;
            }
            else if(s1.length()+1==maxSize && n> maxFreq) {
                maxSize = s1.length()+1;
                maxFreq = n;
                result = s1+c;
            }
            else continue;
        }

        

        
        return result;
    }
}