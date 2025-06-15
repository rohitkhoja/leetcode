class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> inputString = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int tLength = t.length();
        for(char c : t.toCharArray()){
            int n = inputString.getOrDefault(c,0);
            inputString.put(c,n+1);
        }
        String result = "";
        Map<Character, Integer> currentChar = new HashMap<>();
        int startIndex = 0;
        int currentIndex = 0;
        int numberOfElements = 0;
        for(char c : s.toCharArray()){
            if(!inputString.containsKey(c)){
                if(currentIndex == startIndex) {
                    startIndex++;
                }
            }
            
            else {
                int r = inputString.get(c);
                int current = currentChar.getOrDefault(c,0);
                
                if(current<r){ 
                    numberOfElements++;
                }
                
                currentChar.put(c,current+1);
                

                // else {
                //     char start = s.charAt(startIndex);
                //     startIndex++;
                //     while(!inputString.containsKey(s.charAt(startIndex)))
                //     startIndex++;
                //     System.out.println("update start index " + startIndex);
                //     System.out.println("update current index " + currentIndex);
                //     if(start!=c) {
                //         currentChar.put(c,current+1);
                //         int startCount = currentChar.get(start);
                //         int rstartCount = inputString.get(start);
                //         currentChar.put(start,startCount-1);
                //         if(rstartCount > startCount-1)
                //         numberOfElements--;
                //     }
                    
                // }
                 
            }     
            currentIndex++;
            // System.out.println("update current index " + currentIndex+ " elements here "+numberOfElements);
            // System.out.println("update start index " + startIndex+ " length here "+ minLength);
            
            while(numberOfElements == tLength && startIndex < currentIndex){
                    if(numberOfElements == tLength && minLength > (currentIndex-startIndex)) {
                        System.out.println(currentIndex+ "and " + startIndex);
                        minLength = currentIndex-startIndex;
                        result = s.substring(startIndex,currentIndex);
                    }
                    char start = s.charAt(startIndex);
                    int startCount = currentChar.get(start);
                    int rstartCount = inputString.get(start);
                    startIndex++;
                    while(startIndex < currentIndex && !inputString.containsKey(s.charAt(startIndex)))
                    startIndex++;
                    currentChar.put(start,startCount-1);
                    if(rstartCount > startCount-1)
                        numberOfElements--;

            }
               
            

        }

        return result;
    }
}

