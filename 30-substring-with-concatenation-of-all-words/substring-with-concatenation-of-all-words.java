class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Set<Integer> wordsSet = new HashSet<>();
        Set<Integer> visitedSet = new HashSet<>();
        Set<Integer> possible = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> repeatedWords = new HashMap<>();
        Map<Integer,Integer> repeatedWordsCheck = new HashMap<>();

        int n = words[0].length();
        int numberOfWords = words.length;
        int l = s.length();
        int totalLength = n*numberOfWords;

        for(int i=0;i<numberOfWords;i++) {
            if(wordsSet.size()!=0 && wordsSet.contains(words[i].hashCode())){
                int value = repeatedWords.getOrDefault(words[i].hashCode(),0)+1;
                repeatedWords.put(words[i].hashCode(),value);
            }
            else wordsSet.add(words[i].hashCode());
        }
        
        
        for(int i=0;i<l-totalLength+1;i++){
            int startIndex = i;
            if(possible.contains(s.substring(i,i+totalLength).hashCode())) result.add(i);
            else if(wordsSet.contains(s.substring(i,i+n).hashCode())){
                //wordsSet.put(s.substr(i,i+n),true);
                //System.out.println("value of i where first match found "+i);
                visitedSet.add(s.substring(i,i+n).hashCode());
                int j;
                for(j=1;j<numberOfWords;j++){
                    startIndex = startIndex + n;
                    Integer subString = s.substring(startIndex,startIndex+n).hashCode();
                    if(wordsSet.contains(subString) && 
                        !visitedSet.contains(subString)
                    ) visitedSet.add(subString);
                    else if(repeatedWords.containsKey(subString) && 
                        repeatedWords.get(subString) > 
                        repeatedWordsCheck.getOrDefault(subString,0)){
                        int value = repeatedWordsCheck.getOrDefault(subString,0)+1;
                        repeatedWordsCheck.put(subString,value);
                    }
                    else break;
                }
                if (j==numberOfWords) {
                   result.add(i);
                   possible.add(s.substring(i,i+totalLength).hashCode());
                }
                visitedSet.clear();
                repeatedWordsCheck.clear();
            }
        }
        return result;
    }
}