class Solution {
    public int sumFourDivisors(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            // list.add(nums[i]);
            // list.add(1);
            //System.out.println((int) Math.sqrt(nums[i]));
            for(int j=1; j*j <= nums[i]; j++){
                if(nums[i]%j==0){
                    list.add(j);
                    int n1 = nums[i]/j;
                    if(n1!=j)
                    list.add(nums[i]/j);
                }
            }

            if(list.size()==4){
                //System.out.println(nums[i]);
                for(int num:list){
                    sum += num;
                }
            }
        }
        return sum;
    }
}