class Solution {
    Map<Integer,Set<Integer>> map;
    int index;
    Set<Integer> visited;
    Set<Integer> processing;
    public boolean traverse(int node, int[] result){
        if(processing.contains(node)) return false;
        
        if(!visited.contains(node)){
            
            processing.add(node);
            if(map.containsKey(node)) {
                for(int n: map.get(node)){
                    if(!traverse(n, result)) return false;
                }
            }
            index--;
            result[index] = node;
            visited.add(node);
            processing.remove(node);
            return true;
            
        }
        return true;
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        map = new HashMap<>();
        visited = new HashSet<>();
        processing = new HashSet<>();
        int[] result = new int[numCourses];
        int l = prerequisites.length;
        Set<Integer> roots = new HashSet<>();
        index = numCourses;
        for(int i=0;i<l;i++){
            int pre = prerequisites[i][1];
            int main = prerequisites[i][0];
            roots.add(pre);
            roots.add(main);
            if(map.containsKey(pre)){
                map.get(pre).add(main);
            }
            else{
                Set<Integer> set = new HashSet<>();
                set.add(main);
                map.put(pre,set);
            }
        }

        if(l>0 && roots.size()==0) return new int[0];

        for(int root: map.keySet()){
            if(!traverse(root, result)) return new int[0];
        }
        
        for(int i=0;i<numCourses;i++)
            if(!roots.contains(i)){
                index--;
                result[index] = i;
            }

        return result;
        
    }
}