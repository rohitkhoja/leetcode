class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;

        int currentWidth = 0;
        int currentNumberofWords = 0;
        List<String> result = new ArrayList<>();
        int i=0;
        for(i=0;i<n;i++){
            if(currentWidth+words[i].length()+currentNumberofWords<=maxWidth){
                currentWidth += words[i].length();
                currentNumberofWords++;
            }
        
            else{
                StringBuilder sb = new StringBuilder();
                if(currentNumberofWords==1){
                    sb.append(words[i-1]);
                    int c = maxWidth - currentWidth;
                    while(c>0){
                        sb.append(" ");
                        c--;
                    }
                    result.add(sb.toString());
                }

                else{
                    
                    int spaceLength = (maxWidth - currentWidth)/(currentNumberofWords-1);

                    int remaining = (maxWidth - currentWidth)%(currentNumberofWords-1);
                    while(currentNumberofWords>1){
                        sb.append(words[i-currentNumberofWords]);
                        int j = spaceLength;
                        while(j>0) {
                            sb.append(" ");
                            j--;
                        }
                        if(remaining>0){
                           sb.append(" ");
                            remaining--; 
                        }
                        currentNumberofWords--;  
                    }
                    sb.append(words[i-currentNumberofWords]);
                    result.add(sb.toString());
                    
                }
                currentWidth = words[i].length();
                currentNumberofWords=1;            
            }
        }

        StringBuilder sb = new StringBuilder();
        if(currentNumberofWords==1){
            sb.append(words[i-1]);
            int c = maxWidth - currentWidth;
            while(c>0){
                sb.append(" ");
                c--;
            }
            result.add(sb.toString());
        }
        else{
            while(currentNumberofWords>1){
                sb.append(words[i-currentNumberofWords]);
                sb.append(" ");
                currentNumberofWords--;  
            }
            sb.append(words[i-currentNumberofWords]);
            int spaces = maxWidth - sb.length();
            while(spaces>0){
                sb.append(" ");
                spaces--;
            }
            result.add(sb.toString());
            
        }

        return result;


        

       
        
    }
}