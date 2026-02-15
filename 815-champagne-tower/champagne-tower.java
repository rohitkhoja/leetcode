class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        List<List<Double>> list = new ArrayList<>();
        int col = 2;
        if(poured>0) list.add(new ArrayList<>(List.of((double) poured)));
        else return 0;

        for(int i=1;i<=query_row;i++){
            list.add(new ArrayList<>());
            double curr = list.get(i-1).get(0);
            if(curr>1) list.get(i).add((double) 0.5*(curr-1));
            else list.get(i).add((double) 0);
            int j=1;
            for(j=1;j<col-1;j++){
                double total = 0;
                curr = list.get(i-1).get(j-1);
                if(curr>1) total+= (double) 0.5*(curr-1);
                curr = list.get(i-1).get(j);
                if(curr>1) total+= (double) 0.5*(curr-1);
                list.get(i).add(total);
            }
            curr = list.get(i-1).get(j-1);
            if(curr>1) list.get(i).add((double) 0.5*(curr-1));
            else list.get(i).add((double) 0);
            col++;
        }
        //System.out.println(list);
        return list.get(query_row).get(query_glass)>1 ?1:list.get(query_row).get(query_glass);
    }
}