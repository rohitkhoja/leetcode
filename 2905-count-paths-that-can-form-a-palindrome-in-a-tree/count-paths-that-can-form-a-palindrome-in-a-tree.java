class Solution {
    Map<Integer, List<Integer>> map;
    Map<Integer, Integer> mask;

    public long countPalindromePaths(List<Integer> parent, String s) {
        map = new HashMap<>();
        int n = parent.size();
        
        mask = new HashMap<>();
        mask.put(0,0);
        for(int i=1;i<n;i++){
            int p = parent.get(i);
            //int m = 0;
            int m = 1 << s.charAt(i)-'a';
            List<Integer> list = map.getOrDefault(p,new ArrayList<>());
            list.add(i);
            map.put(p, list);
            mask.put(i,m);
        }
        calcMask(0);

        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0,1);
        long answer = 0;
        for(int i=1;i<n;i++){
            int m = mask.get(i);
            answer += freq.getOrDefault(m,0);

            for(int j=0;j<26;j++){
                int temp = m^ 1<< j;
                answer += freq.getOrDefault(temp,0);
            }
            freq.put(m, freq.getOrDefault(m,0)+1);
        }


        return answer;
        
    }

    public void calcMask(int node){
        int m = mask.get(node);
        List<Integer> l1 = map.getOrDefault(node, new ArrayList<>());
        for(int c:l1){
            mask.put(c, m^mask.get(c));
            calcMask(c);
        }
    }
}