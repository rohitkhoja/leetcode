class Solution {
    
    class ChangeCost{
        int c;
        int cost;

        public ChangeCost(int c, int cost){
            this.c = c;
            this.cost = cost;
        }
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        
        Map<Integer, List<ChangeCost>> map = new HashMap<>();

        int l = original.length;

        for(int i=0;i<l;i++){
            map.computeIfAbsent(original[i]-'a', k -> new ArrayList<>())
                .add(new ChangeCost(changed[i]-'a', cost[i]));
        }

        long[][] distance = new long[26][26];
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(i==j) distance[i][j]=0;
                else {
                    distance[i][j] = Long.MAX_VALUE;
                    if(map.containsKey(i)){
                        for(ChangeCost cc: map.get(i)){
                            if(cc.c==j) distance[i][j] = Math.min(distance[i][j],cc.cost); 
                        }
                    }
                }
            }
        }

        

        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(distance[i][k]!=Long.MAX_VALUE && distance[k][j]!=Long.MAX_VALUE)
                        distance[i][j] = Math.min(distance[i][j], distance[i][k]+distance[k][j]);

                }
            }
        }
        

       
        
        long totalCost = 0;
        for(int i=0;i<n;i++){
            int sourceChar = source.charAt(i)-'a';
            int targetChar = target.charAt(i)-'a';

            if(sourceChar!=targetChar) {
                
                
                
                long indexCost = distance[sourceChar][targetChar];
                if(indexCost==Long.MAX_VALUE) return -1;
                
                totalCost += indexCost;
                
                
            }
                
        }

        return totalCost;


    }

}