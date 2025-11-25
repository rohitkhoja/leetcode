class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        if(n==1) return triangle.get(0).get(0);

        for(int i=n-2;i>=0;i--){
            int sz = triangle.get(i).size();
            for(int j=0; j<sz; j++){
                int num = Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1));
                num += triangle.get(i).get(j);
                //System.out.println(i+".."+j+".."+num);
                triangle.get(i).set(j, num);
            }
        }
        return triangle.get(0).get(0);
        
    }
}