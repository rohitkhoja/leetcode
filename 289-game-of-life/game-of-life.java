class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] matrix = new int[row][col];
        int oldValue = 0;
        int sumOld = 0;
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                matrix[i][j] = board[i][j];
            }

        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                int n=0;
                n = get(i,j-1,matrix) + get(i,j+1,matrix) + get(i-1,j-1,matrix) 
                    +get(i-1,j,matrix) + get(i+1,j+1,matrix) + get(i+1,j,matrix) 
                    +get(i-1,j+1,matrix) + get(i+1,j-1,matrix);

                // i-1,j
                // i+1,j
                // // i,j-1
                // // i,j+1
                // // i-1,j-1
                // i+1,j+1
                // i-1,j+1
                // i+1,j-1    
                
                if(n==3)
                  board[i][j] = 1;
                else if(n==2)
                  continue;  
                else
                  board[i][j] = 0;
            }
    }
    public int get(int i, int j, int[][] matrix){
        try {
            return matrix[i][j];
        }
        catch (Exception e){
            return 0;
        }
    }
}

// cindition neighbout < 2 or neighbour > 3 die = 0
// neighbour =3 all 1 if 2 check already aline or not 

// 1 1 1 1 1 1 1 1 1 1 1 
// 1 1 1 1 1 1 1 1 1 1 1
// 1 1 1 1 1 1 1 1 1 1 1 
// 1 1 1 1 1 1 1 1 1 1 1
// 1 1 1 1 1 1 1 1 1 1 1 
// 1 1 1 1 1 1 1 1 1 1 1 