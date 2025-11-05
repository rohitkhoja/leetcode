class Solution {
    int result;
    int N;
    public int totalNQueens(int n) {
        result=0;
        N=n;
        Set<Integer> col = new HashSet<>();
        Set<Integer> diag1 = new HashSet<>();
        Set<Integer> diag2 = new HashSet<>();
        search(col, diag1, diag2, 0);

        return result;
    }

    public void search(Set<Integer> col, Set<Integer> diag1, Set<Integer> diag2, int index){
        if(index==N){
            result++;
            return;
        }

        for(int i=0;i<N;i++){
            if(!col.contains(i) && !diag1.contains(i-index) && !diag2.contains(i+index)){
                col.add(i);
                diag1.add(i-index);
                diag2.add(i+index);
                search(col, diag1, diag2, index+1);
                col.remove(i);
                diag1.remove(i-index);
                diag2.remove(i+index);
            }
        }
    }
}