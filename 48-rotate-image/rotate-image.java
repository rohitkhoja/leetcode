class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length-1;
        int i=0;
        while(i<row){
            layerRotation(i,row,matrix);
            i++;
            row--;            
        }
    }    
        
    public void layerRotation(int i, int row, int[][] matrix){    
        for(int n=0;n+i<row;n++){
            int temp = matrix[i][i+n];
            matrix[i][i+n] = matrix[row-n][i];
            matrix[row-n][i] = matrix[row][row-n];
            matrix[row][row-n] = matrix[i+n][row];
            matrix[i+n][row] = temp;
        }
    }
}