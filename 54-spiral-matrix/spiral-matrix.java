class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int col = matrix.length;
        int row = matrix[0].length;
        Set<String> track = new HashSet<>();
        int i=0;
        int j=0;
        int jNew = -1;
        int iNew = -1;
        List<Integer> result = new ArrayList<>();
        while(true){
            Pair<Integer, Integer> pair = moveEast(i, j, row, track, result, matrix);
            // System.out.println(track);
            if(result.size()==row*col)   return result; 
            pair = moveSouth(pair.getKey(), pair.getValue(),
                                            col, track, result, matrix);
            if(result.size()==row*col)   return result;                              
            // System.out.println(track);
            pair = moveWest(pair.getKey(), pair.getValue(),
                                            row, track, result, matrix);
            // System.out.println(result);
            if(result.size()==row*col)   return result; 
            pair = moveNorth(pair.getKey(), pair.getValue(),
                                            col, track, result, matrix);
            if(result.size()==row*col)   return result;                                 
            // System.out.println(result);
            i = pair.getKey();
            j =  pair.getValue();
       
        }
        
    }
    public Pair<Integer, Integer> moveEast(int i, int j, int row,
        Set<String> track, List<Integer> result, int[][] matrix){
        while(i<row && !track.contains(""+j+i)){
            result.add(matrix[j][i]);
            track.add(""+j+i);
            i++;
        }
        i--;
        j++;
        return new Pair<>(i,j);    
    }
        
    public Pair<Integer, Integer> moveSouth(int i, int j, int col,
        Set<String> track, List<Integer> result, int[][] matrix){
        while(j<col && !track.contains(""+j+i)){
            // System.out.println(i+" "+j+ " "+col);
            result.add(matrix[j][i]);
            track.add(""+j+i);
            j++;
        }
        j--;
        i--;
        return new Pair<>(i,j); 
    }
    public Pair<Integer, Integer> moveWest(int i, int j, int row,
        Set<String> track, List<Integer> result, int[][] matrix){
        //System.out.println(i+" "+j+ " ");
        while(i>=0 && !track.contains(""+j+i)){
            
            result.add(matrix[j][i]);
            track.add(""+j+i);
            i--;
        }
        i++;
        j--;
        return new Pair<>(i,j); 
    }
    public Pair<Integer, Integer> moveNorth(int i, int j, int col,
        Set<String> track, List<Integer> result, int[][] matrix){
        while(j>=0 && !track.contains(""+j+i)){
            // System.out.println(track);
            // System.out.println(i+" "+j);
            result.add(matrix[j][i]);
            track.add(""+j+i);
            j--;
        }
        j++;
        i++;
        return new Pair<>(i,j); 
    }


}

// first move East, untill reach till last point or visited node, i++, j constant
// move south, same condition, j++, i constant
// move west ,same condition, i--, j constant
// move north, same condition, j-- , i constant

// 1 2 3 
// 4 5 6
// 7 8 9 