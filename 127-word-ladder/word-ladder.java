class Solution {

    public boolean isoneDifference(String s, String t){
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int count =0;
        for(int i=0;i<s1.length;i++){
            if(s1[i]!=t1[i]) count++;
        }
        if(count==1) return true;
        return false;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> set = new HashSet<>();

        for(String s: wordList){
            set.add(s);
        }
      

        set.add(beginWord);
        Map<String, Set<String>> map = new HashMap<>();

        for(String s: set){
            Set<String> sw = new HashSet<>();
            for(String s1: set){
                if(isoneDifference(s,s1))
                    sw.add(s1);
            }
            map.put(s,sw);
        }

        Deque<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        set.remove(beginWord);
        int result =0;

        while(!q.isEmpty()){
            int l = q.size();
            for(int i=0;i<l;i++){
                String s = q.poll();
                if(s.equals(endWord)) return result+1;
                for(String s1: map.get(s)){
                    if(set.contains(s1)){
                        q.offer(s1);
                        set.remove(s1);
                    }
                }
            }
            result++;
        }
        return 0;
    }
}