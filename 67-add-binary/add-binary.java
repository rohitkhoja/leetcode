class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int n1 = a.length()-1;
        int n2 = b.length()-1;
        boolean carry = false;

        while(n1>=0 && n2>=0){
            if(a.charAt(n1)=='1' && b.charAt(n2)=='1'){
                if(carry) sb.append("1");
                else sb.append("0");
                carry = true;
            }
            else if((a.charAt(n1)=='1' && b.charAt(n2)=='0') || 
                (a.charAt(n1)=='0' && b.charAt(n2)=='1') ){
                    
                    if(!carry) sb.append("1");
                    else sb.append("0");
            } 
            else{
                if(carry) sb.append("1");
                else sb.append("0");
                carry = false;
            }
            n1--;
            n2--;

        }

        while(n1>=0){
            if(a.charAt(n1)=='1'){
                if(carry) sb.append("0");
                else sb.append("1");
            }
            else {
                if(!carry) sb.append("0");
                else sb.append("1");
                carry = false;
            }
            n1--;
        }
        while(n2>=0){
            if(b.charAt(n2)=='1'){
                if(carry) sb.append("0");
                else sb.append("1");
            }
            else {
                if(!carry) sb.append("0");
                else sb.append("1");
                carry = false;
            }
            n2--;
        }

       if(carry) sb.append("1");
       return sb.reverse().toString();
    }
}