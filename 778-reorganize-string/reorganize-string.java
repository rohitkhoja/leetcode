class Solution {

    class Element{
        char ch;
        int count;

        public Element(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }

    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        PriorityQueue<Element> pq = new PriorityQueue<>((a,b)-> Integer.compare(b.count, a.count));
        int n = s.length();
        for(char c: s.toCharArray()){
            
            if(map.containsKey(c)) {
                int n1 = map.get(c);
                map.put(c, n1+1);
            }
            else map.put(c,1);
        }

        map.forEach((k,v)-> pq.add(new Element(k,v)) );
        if(pq.peek().count > (n+1)/2) return "";
        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            Element e = pq.poll();
            sb.append(e.ch);
            e.count--;
            if(pq.isEmpty()) return sb.toString();

            Element e1 = pq.poll();
            sb.append(e1.ch);
            e1.count--;
            if(e.count!=0) pq.add(e);
            if(e1.count!=0) pq.add(e1);
        }       
        return sb.toString();
    }
}