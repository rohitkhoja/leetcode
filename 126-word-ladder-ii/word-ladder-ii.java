class Solution {
    public int difference(String s, String t){
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int count =0;
        for(int i=0;i<s1.length;i++){
            if(s1[i]!=t1[i]) count++;
        }
        return count;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return new ArrayList<>();
        if(difference(beginWord,endWord)==1) {
            List<String> s = new ArrayList<>();
            s.add(beginWord);
            s.add(endWord);
            List<List<String>> result = new ArrayList<>();;
            result.add(s);
            return result;
        }
        Set<String> set = new HashSet<>();

        for(String s: wordList){
            set.add(s);
        }
      
        int len = beginWord.length();
        //set.add(beginWord);
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Set<String>> diff = new HashMap<>();
        for(String s: set){
            for(int i=0;i<len;i++){
                String pat = s.substring(0,i)+'*'+s.substring(i+1);
                map.computeIfAbsent(pat,k -> new HashSet<>()).add(s);
            }
            //map.put(s,difference(s,beginWord));
        }
        
        
        List<List<String>> result = new ArrayList<>();
         
        Deque<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        set.remove(beginWord);
        //int result =0;
        boolean found = false;
        Set<String> rset = new HashSet<>();
        //rset
        while(!q.isEmpty()){
            int l = q.size();
            System.out.println(l);
            Set<String> removal  = new HashSet<>();
            for(int i=0;i<l;i++){
                String s = q.poll();
                //if(s.equals(endWord)) return result+1;
                for(int j=0;j<len;j++){
                    String pat = s.substring(0,j)+'*'+s.substring(j+1);
                    if(map.containsKey(pat)){
                        for(String s1: map.get(pat)){
                            if(set.contains(s1) && !s1.equals(endWord)){
                                q.offer(s1);
                                diff.computeIfAbsent(s1,k -> new HashSet<>()).add(s);
                                if(q.size()>2000)
                                set.remove(s1);
                                removal.add(s1);
                            }
                            if(s1.equals(endWord)){
                                rset.add(s);
                                // List<String> list = new ArrayList<>();
                                // //System.out.println(s);
                                // list.add(s);
                                // result.add(list);
                                found = true;
                            }
                           
                        }
                    }
                }
            }
            // if(found){
            //     for(String rm:removal) 
            //         diff.remove(rm);
            // }
            if(found) break;
            for(String rm:removal) set.remove(rm);
        }
        
        if(!found) return new ArrayList<>();
        found = false;
        for(String s1: rset){
            List<String> new1 = new ArrayList<>();
            new1.add(s1);
            result.add(new1);
        }

        System.out.println(result);
        System.out.println(diff);
        while(!found){
            List<List<String>> r1  = new ArrayList<>();

            for(List<String> list: result){
                //System.out.println(list);
                int size = list.size();
                Set<String> stlst = diff.get(list.get(size-1));

                if(stlst.contains(beginWord)){
                    list.add(beginWord);
                    found = true;
                }
                else{
                    for(String st: stlst ){
                        List<String> new1 = new ArrayList<>(list);
                        new1.add(st);
                        r1.add(new1);
                    }

                }
            }
            if(!found)
            result = r1;
            //System.out.println(result);
        }
        for(List<String> stlst: result){
            Collections.reverse(stlst);
            stlst.add(endWord);
        }
        return result;
    }
}