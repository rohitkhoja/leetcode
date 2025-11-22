class Solution {
    public int minimumFlips(int n) {

       List<Integer> list  = new ArrayList<>();

        while(n>0){
            int temp = 0;

            temp = n & 1;
            list.add(n & 1);

            n >>>= 1;
        }
        int sum=0;
        int i=0;
        int j=list.size()-1;
        while(i<j){
            if(list.get(i)!=list.get(j))
                sum+=2;

            i++;
            j--;
        }
            
        
        //System.out.println(list);    

        return sum;
    }
}