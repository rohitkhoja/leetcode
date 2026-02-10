class Solution {
    public int longestBalanced(int[] nums) {
        int l = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int result = 0;
        int[] preEven = new int[l];
        int[] preOdd = new int[l];
        
        //  if(nums[0]%2==0){
        //      preEven[0] = 1;
        //      preOdd[0] = 0;
        //      even.add(nums[0]);
        //  }
        // else {
        //     preEven[0] = 0;
        //     preOdd[0] = 1;
        //     odd.add(nums[0]);
        // }
        // map.put(preEven[0]-preOdd[0],0);
        for(int i=0;i<l;i++){
            Set<Integer> even  = new HashSet<>();
            Set<Integer> odd  = new HashSet<>();
            for(int j=i;j<l;j++){
                
                if(nums[j]%2==0){
                        even.add(nums[j]);
                }
                else{
                        odd.add(nums[j]);
                }
                if(even.size() == odd.size())
                    result = Math.max(result, j-i+1);
                // int check =  preEven[i]-preOdd[i];
                // if(map.containsKey(check)){
                //     System.out.println(even.size()+"cc");
                //     if(even.size()>0 && odd.size()>0)
                //     result = Math.max(result, i-map.get(check));
                //     System.out.println(odd.size());
                // }
                // else map.put(check,i);
            }
        }
        return result;
    }
}