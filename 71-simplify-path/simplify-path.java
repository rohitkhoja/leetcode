class Solution {
    public String simplifyPath(String path) {
        int l = path.length();
        String result = "";
        int countDot = 0;
        int countSlash = 0;
        for(int i=l-1;i>=0;){
            if(path.charAt(i)=='/'){
                if(i!=l-1) result+='/';
                while(i>=0 && path.charAt(i)=='/') i--;
                
            }
            else if(path.charAt(i)=='.' && i+1<=l-1 && path.charAt(i+1)!='/'){
                while(i>=0 && path.charAt(i)=='.'){
                        i--;
                        result+='.';
                    }
            }
            else if(path.charAt(i)=='.'){
                while(i>=0 && path.charAt(i)=='.'){
                    i--;
                    countDot++;
                }
                System.out.println(countDot+" "+i);

                if(countDot>2 || path.charAt(i)!='/'){
                    while(countDot>0){
                       result+='.';
                       countDot--;
                    }
                } 
                else if(countDot==2){
                    countSlash = 2;
                    while(i>=0 && countSlash>0){
                        if(path.charAt(i)=='/') {
                            while(i>=0 && path.charAt(i)=='/') i--;
                            countSlash--;
                        }
                        else if(path.charAt(i)=='.'){
                            int c = 0;
                            while(i>=0 && path.charAt(i)=='.'){
                                i--;
                                c++;
                            } 
                            if(c==2) countSlash+=2;
                            else if(c==1 && i+2<l-1 && path.charAt(i+2)=='/') countSlash+=1;
                        }
                        else i--;
                    }
                    countDot=0;
                }
                else {
                    while(i>=0 &&  path.charAt(i)=='/') i--;
                    countDot=0;
                }

            }
            else {
                result+=path.charAt(i);
                i--;
            }
        }
        String result1 = new StringBuilder(result).reverse().toString();
        if(result.length()==0) return "/";
        else return result1;
    }
}