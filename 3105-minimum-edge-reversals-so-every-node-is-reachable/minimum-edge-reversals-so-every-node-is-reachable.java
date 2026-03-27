class Solution {
    Map<Integer, Integer> costMap;
    Map<Integer, List<Integer>> edgesMap;
    Map<Integer, List<Integer>> parentMap;
    int cost;
    public int[] minEdgeReversals(int n, int[][] edges) {

        edgesMap = new HashMap<>();
        costMap = new HashMap<>();
        parentMap = new HashMap<>();
        cost = 0;
        for(int i=0;i<n;i++){
            edgesMap.put(i,new ArrayList<>());
            parentMap.put(i,new ArrayList<>());
        }

        int[] results = new int[n];
        int l = edges.length;
        for(int i=0;i<l;i++){
            edgesMap.get(edges[i][0]).add(edges[i][1]);
            parentMap.get(edges[i][1]).add(edges[i][0]);
        }
         

        costMap.put(0,0);
        calcCost(0);
        results[0] = cost;
        for(int i=1;i<n;i++){
            results[i] = results[0]+costMap.get(i);
        }

        return results;
        
    }

    public void calcCost(int node){
        int cost1 = costMap.get(node);
        List<Integer> parentList = parentMap.get(node);
        List<Integer> childList  = edgesMap.get(node);
        for(int child: childList){
            if(costMap.containsKey(child)) continue;
            costMap.put(child, cost1+1);
            calcCost(child);
        }
        for(int parent: parentList){
            if(costMap.containsKey(parent)) continue;
            costMap.put(parent, cost1-1);
            cost++;
            calcCost(parent);
        }
    }
}