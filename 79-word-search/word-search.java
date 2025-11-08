class Solution {
    int[] x = {1,-1,0,0};
    int[] y = {0,0,1,-1};
    int m;
    int n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        for(int i=0;i<board.length;i++)
            for( int j=0;j<board[0].length;j++)
                if(word.charAt(0)==board[i][j] && search(board, word, 1,i,j))
                    return true;

        return false;            
        
    }

    public boolean search(char[][] board, String word, int index, int i, int j){
        if(index==word.length()) return true;
        char temp = board[i][j];
        board[i][j] = '*';
        for(int k=0;k<4;k++){
            int i1 = i+x[k];
            int j1 = j+y[k];
            if(i1>=0 && j1>=0 && i1<m && j1<n && word.charAt(index)==board[i1][j1] && search(board, word, index+1,i1,j1))
                return true;
        }
        board[i][j] = temp;

        return false;

    }
}