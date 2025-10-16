class Solution {

    Map<Integer,Set<Integer>> map;
    public boolean traverse(int key, Set<Integer> visited, int target ){
        if(key==target) return false;
        if(!visited.contains(key)){
            visited.add(key);
            if(map.containsKey(key))
                for(int k: map.get(key))
                    if(!traverse(k, visited, target)) return false;
            
        }
        
        return true;

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
         
        if(prerequisites.length==0) return true;
        map = new HashMap<>();
        int l = prerequisites.length;
        for(int i=0;i<l;i++){
            int main = prerequisites[i][0];
            int preReq = prerequisites[i][1];
            if(map.containsKey(main)){
                map.get(main).add(preReq);
            }
            else{
                Set<Integer> set = new HashSet<>();
                set.add(preReq);
                map.put(main,set);
            }
        }

        for(int target: map.keySet()){
            Set<Integer> visited =  new HashSet<>();
            for(int key: map.get(target)){
                 if(!traverse(key, visited, target)) return false;
            }
            
        }
        return true;
    }
}