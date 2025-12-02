class Solution {
    public int countElements(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        int n = nums.length;
        int i = n-1;
        List<Integer> list = new ArrayList<>();
        int last = 0;
        while(i>=0 && list.size()<k){
            list.add(nums[i]);
            last = nums[i];
            i--;
        }
        
        while(i>=0 && nums[i]==last) {
            i--;
        }
        //System.out.println(i+1);
        return i+1;
        
    }
}