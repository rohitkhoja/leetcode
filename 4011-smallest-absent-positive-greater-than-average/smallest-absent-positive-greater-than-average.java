class Solution {
    public int smallestAbsent(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int l = nums.length;
        int sum = 0;
        for(int num: nums){
            sum+=num;
            set.add(num);
        }
        int avg = sum/l;
        avg++;
        if(avg<=0) avg = 1;
        while(set.contains(avg)) avg++;
        
        return avg;
        
    }
}