class Solution {

    Map<String, Map<String,Double>> map;

    public double traverse(Set<String> visited, String s, String target){
        if(visited.contains(s)) return -1;
        visited.add(s);
        Map<String,Double> m = map.get(s);
        if(m.containsKey(target)) return m.get(target);

        for(Map.Entry<String,Double> entry: m.entrySet()){
            if(!visited.contains(entry.getKey())){
                double v = traverse(visited, entry.getKey(), target);
                if(v!=-1){
                        return entry.getValue() * v;
                }
            }
        }
        return -1;
    }


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        map = new HashMap<>();
        double[] result = new double[queries.size()];
        int l = equations.size();
        for(int i=0;i<l;i++){
            List<String> equation = equations.get(i);
            String s1 = equation.get(0);
            String s2 = equation.get(1);
            double value = values[i];
            if(map.containsKey(s1)){
                Map<String,Double> m1 = map.get(s1);
                m1.put(s2, value);
            }
            else{
                Map<String,Double> m1 = new HashMap<>();
                m1.put(s2, value);
                map.put(s1,m1);
            }
            if(map.containsKey(s2)){
                Map<String,Double> m2 = map.get(s2);
                m2.put(s1, 1/value);
            }
            else{
                Map<String,Double> m2 = new HashMap<>();
                m2.put(s1, 1/value);
                map.put(s2,m2);
            }
        }
        int i=0;
        for(List<String> query: queries){
            String q1 = query.get(0);
            String q2 = query.get(1);
            if(map.containsKey(q1)){
                Set<String> visited = new HashSet<>();
                result[i] = traverse(visited, q1, q2);
            }
            else{
                result[i] = -1;
            }
            i++;
        }

        return result;


        
    }
}