class Solution {

    
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        int result = n;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j]==1){
                    int parentI = i;
                    int parentJ = j;
                    if(map.containsKey(parentI)){
                        while(map.containsKey(parentI))
                            parentI = map.get(parentI);
                    }
                    if(map.containsKey(parentJ)){
                        while(map.containsKey(parentJ))
                            parentJ = map.get(parentJ);
                    }
                    if(parentI!=parentJ){
                        result--;
                        map.put(parentI,parentJ);
                    }
                }
            }
        }
        return result;
    }
}

// [[1,0,0,1],
//  [0,1,1,0],
//  [0,1,1,1],
//  [1,0,1,1]]