class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length-1;
        int col = row;
        int i=0;
        int j=0;
        while(i<row){
            layerRotation(i,j,row,col,matrix);

            i++;
            j++;
            row--;
            col--;
            System.out.println(i+" "+j+" "+" "+row+" "+col);
            System.out.println(matrix);
        }
    }    
        
    public void layerRotation(int i, int j, int row, int col, int[][] matrix){
        for(int n=0;n+i<row;n++){
            int temp = matrix[i][j+n];
            matrix[i][j+n] = matrix[row-n][j];
            matrix[row-n][j] = matrix[row][col-n];
            matrix[row][col-n] = matrix[i+n][col];
            matrix[i+n][col] = temp;
        }
    }
}



// (i,j)      (row,j)      (row,col)      (i,col)
// i,j+1      row-1,j             col-1    i+1
// i,j+2
// i,j+3
// untill reach row

//first loop done i++, j++, row--, col-- start to that function

// i,j store , mov row,j --> i,j, mov row,col --> row,j,  mov i,col --> row,col,  mov store --> i,col
// i1,j store, mov row-1,j --> i1,j, mov row,col-1-->  , mov i+1,col            i+1,j --> 
// 
