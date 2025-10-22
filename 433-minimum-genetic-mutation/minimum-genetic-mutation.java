class Solution {

    public boolean isOneDistance(String s, String e){
        char[] sg = s.toCharArray();
        char[] eg = e.toCharArray();
        int count = 0;
        for(int i=0;i<sg.length;i++){
            if(sg[i]!=eg[i]) count++;
        }
        if(count==1) return true;
        return false;
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        //if(isOneDistance(startGene, endGene)) return 1;
        Set<String> b = new HashSet<>();
        for(int i=0;i<bank.length;i++){
            b.add(bank[i]);
        }
        b.add(startGene);
        //b.add(endGene);
        Map<String, Set<String>> map = new HashMap<>();

        for(String s: b){
            Set<String> set = new HashSet<>();
            for(String s1: b){
                if(isOneDistance(s, s1)){
                    set.add(s1);
                }
            }
            map.put(s,set);
        }
        
        Deque<String> q = new ArrayDeque<>();
        q.offer(startGene);
        int result = 0;
        b.remove(startGene);
        while(!q.isEmpty()){
            //System.out.println(q);
            int sz = q.size();
            for(int i=0;i<sz;i++){
                String s = q.poll();
                if(s.equals(endGene)) return result;
                for(String s1: map.get(s)){
                    System.out.println(s1);
                    if(b.contains(s1)){
                        
                        q.offer(s1);
                        b.remove(s1);
                        
                    }
                }
            }
            result++;
            
        }

        return -1;



        
    }
}