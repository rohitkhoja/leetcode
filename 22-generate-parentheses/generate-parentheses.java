class Solution {
    int N;
    int n1;
    int n2;
    List<String> result;
    public List<String> generateParenthesis(int n) {
        N=n;
        n1=0;
        n2=0;
        result = new ArrayList<>();
        search(new StringBuilder());
        return result;


    }

    public void search(StringBuilder s){
        if(s.length()==2*N){
            result.add(s.toString());
            return;
        }
         
        
        if(n1<N){
            s.append("(");
            n1++;
            search( s);
            s.deleteCharAt(s.length()-1);
            n1--;
        }

        if(n2<N && n2<n1){
            s.append(")");
            n2++;
            search( s);
            s.deleteCharAt(s.length()-1);
            n2--;
        }
        
        
    }
}