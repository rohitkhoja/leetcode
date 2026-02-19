class Solution {
    public List<List<Integer>> generate(int numRows) {
     List<List<Integer>> list = new ArrayList<>();

     list.add(List.of(1));
      numRows--;

      for(int i=0;i<numRows;i++){
        List<Integer> l = list.get(list.size()-1);
        int sz = l.size();

        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        for(int j=1;j<sz;j++){
            int add = 0;
            add += l.get(j-1);
            add+= l.get(j);
            l1.add(add);
        }
        l1.add(1);
        list.add(l1);

      }

      return list;
      
    }
}