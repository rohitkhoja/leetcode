class Solution {
    public void setZeroes(int[][] matrix) {
    Set<Integer> rowList = new HashSet<>();
    Set<Integer> colList = new HashSet<>();
    int row = matrix.length;
    int col = matrix[0].length;
    for(int i=0;i<row;i++)
        for(int j=0;j<col;j++) {
            if(matrix[i][j]==0)
            { rowList.add(i);
              colList.add(j);
            }
        } 
    for(int i=0;i<row;i++)
        for(int j=0;j<col;j++) {
            if(rowList.contains(i) || colList.contains(j))
            matrix[i][j]=0;
        }     
    }
}