class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> inputString = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int sti = 0;
        int str= Integer.MAX_VALUE;
        int tLength = t.length();
        for(char c : t.toCharArray()){
            int n = inputString.getOrDefault(c,0);
            inputString.put(c,n+1);
        }
        List<Pair<Character, Integer>> charList = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(inputString.containsKey(s.charAt(i)))
                charList.add(new Pair<>(s.charAt(i),i));
        }
        String result = "";
        Map<Character, Integer> currentChar = new HashMap<>();
        int j = 0;
        int numberOfElements = 0;

        for(int i=0;i<charList.size();i++){
            char c = charList.get(i).getKey();
            int r = inputString.get(c);
            int current = currentChar.getOrDefault(c,0);
            if(current<r){ 
                    numberOfElements++;
            }
            currentChar.put(c,current+1);
            while(numberOfElements == tLength  ){
                    int startIndex = charList.get(j).getValue();
                    char startChar = charList.get(j).getKey();
                    int currentIndex = charList.get(i).getValue();
                    System.out.println("currentIndex"+currentIndex);
                    System.out.println("startIndex"+startIndex);
                    if(numberOfElements == tLength && minLength > (currentIndex-startIndex)) {
                        minLength = currentIndex-startIndex;
                        sti = startIndex;
                        str = currentIndex;
                        //result = s.substring(startIndex,currentIndex+1);
                    }
                    
                    int startCount = currentChar.get(startChar);
                    int rstartCount = inputString.get(startChar);
                    j++;
                    if(rstartCount > startCount-1)
                        numberOfElements--;
                    currentChar.put(startChar,startCount-1);
            }

        }
        if(str!=Integer.MAX_VALUE)
        return s.substring(sti,str+1);
        else return result;
    }
}

