class Solution {
    int N;
    List<List<String>> result;
    List<String> list;
    public List<List<String>> solveNQueens(int n) {
        N=n;
        result = new ArrayList<>();
        list = new ArrayList<>();
        Set<Integer> col = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();
        search(col, posDiag, negDiag,0);
        return result;
    }

    public void search(Set<Integer> col, Set<Integer> posDiag, Set<Integer> negDiag, int index){
        if(index==N){
            result.add(new ArrayList<>(list));
        }

        for(int i=0;i<N;i++){
            if(!col.contains(i) && !posDiag.contains(i-index) && !negDiag.contains(i+index)){
                col.add(i);
                posDiag.add(i-index);
                negDiag.add(i+index);
                String s = "";
                int n = i;
                while(n>0){
                    s += ".";
                    n--;
                }
                s += "Q";
                while(s.length()<N) s += ".";
                list.add(s);
                search(col, posDiag, negDiag, index+1);
                list.remove(list.size()-1);
                col.remove(i);
                posDiag.remove(i-index);
                negDiag.remove(i+index);
            }
        }
    }
}