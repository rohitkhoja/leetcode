class Solution {
    public String nextPermutation(String s){
        char[] charArray = s.toCharArray();
        int l = charArray.length;
       System.out.println(s);
        if(l<2) return "";
        int i=0, j=0;
        for(i=l-2;i>=0;i--){
            if(charArray[i]<charArray[i+1]) break;
        }
        if(i==-1) return "";
        for(j=i+1;j<l;j++){
            if(charArray[j]<=charArray[i]) break;
        }
        
        char temp = charArray[j-1];
        charArray[j-1] = charArray[i];
        charArray[i] = temp;
        String result = "";
        for(j=0;j<i+1;j++) result+=charArray[j];
        for(j=l-1;j>i;j--) result+=charArray[j];
         System.out.println(result);
        return result;
    }
    
    public String lexGreaterPermutation(String s, String target) {
       Map<Character, Integer> map = new HashMap<>();
        
       if(s.length()!=target.length()) return "";
       for(char c: s.toCharArray()){
           if(map.containsKey(c)){
               int n = map.get(c);
               map.put(c,n+1);
           }
           else {
               map.put(c,1);
           }
       }
       String result = "";
        boolean exit = false;
       for(char c: target.toCharArray()) {
           if(map.containsKey(c)){
               result  += c;
           }
           else{
               char temp = c;
               while(!map.containsKey(c)){
                   if(c=='z') {
                       char[] ca = result.toCharArray();
                       int len = ca.length;
                       //if(len==1) return "";
                       int q=0;
                       for(q = len-1; q>=0; q--){
                           char check = (char) (ca[q]);
                            
                           if(map.containsKey(check)){
                               int n = map.get(check);
                               map.put(check,n+1);
                           }
                           else {
                               map.put(check,1);
                           }
                          
                           check = (char) (check+1);
                           while(!map.containsKey(check)) {
                               check = (char) (check+1);
                               if(check>'z') break;
                           }
                           if(check<='z'){
                               temp = check;
                               break;
                           }
                       }
                       if(q==-1) return "";
                        result = "";
                       for(int j=0;j<q;j++){
                           result +=ca[j];
                       }
                       result += temp;
                       int n = map.get(temp);
                        if(n==1) map.remove(temp);
                        else map.put(temp,n-1);
                       
                       List<Character> chars = new ArrayList<>();
                        for(char c1: map.keySet()){
                           n = map.get(c1);
                           while(n>0){
                               chars.add(c1);
                               n--;
                           }
                       } 
                      Collections.sort(chars);  
                      for(char c1: chars)
                          result += c1;
                      return  result; 
                                       
                       
                       
                   }
                   c = (char) (c+1);
                   
                   
               }
               result  += c;
               exit = true;
           }
           int n = map.get(c);
            if(n==1) map.remove(c);
            else map.put(c,n-1);
           if(exit) break;
           
       }
        
        if(!exit) {
            result = "";
            int l = target.length();
            if(l==1) return "";
            char[] chars = target.toCharArray();
            int lastIndex = l-1;
            for(int i=l-2;i>=0;i--){
                if(chars[i]<chars[i+1]){
                    char temp = chars[i];
                    int j = i+1;
                    for(j=i+1;j<l;j++){
                        if(chars[j]<=chars[i])
                           break;
                    }
                    chars[i] = chars[j-1];
                    chars[j-1] = temp;
                    for(j=0;j<i+1;j++){
                        result = result+chars[j];
                    }
                    for(j=l-1;j>i;j--){
                        result += chars[j];
                    }
                    return result;
                }
                if(i==0) return "";
            }
            return new String(chars);
        };
        
        List<Character> chars = new ArrayList<>();
        for(char c: map.keySet()){
           int n = map.get(c);
           while(n>0){
               chars.add(c);
               n--;
           }
       } 
      Collections.sort(chars);  
      for(char c: chars)
          result += c;
      return  result; 
    }
}