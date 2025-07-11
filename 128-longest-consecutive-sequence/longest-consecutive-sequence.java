class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        int result=0;
        for(int num:nums){
            set.add(num);
        }
        
        for(int num:set){
            if(set1.contains(num)) continue;
            int n = 1;
            int num1 = num;
            while(set.contains(num+1))
            {
                n++;
                set1.add(num+1);
                num++;
            }
            while(set.contains(num1-1)){
                n++;
                set1.add(num1-1);
                num1--;
            }
            result = Math.max(result,n);
        }
        return result;
    }
}