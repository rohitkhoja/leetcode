class Solution {
    int max;
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        max = k;
        Set<Integer> set = new HashSet<>();
        int[] nums = new int[n];
        int i=0;
        
        for(i=0;i<n;i++){
            nums[i]=i+1;
            //System.out.println(nums[i]);
        }
        
        for(i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            //list.add(nums[i]);
            search(nums, list, i);
        }
        return result;
    }

    public void search(int[] nums, List<Integer> list, int index){
        //System.out.println(max);
        list.add(nums[index]);
        if(list.size()==max) {
            result.add(list);
            return;
        }
        if(nums.length-index<max-list.size()) return;
        for(int i=index+1;i<nums.length;i++){
            //List<Integer> list = new ArrayList<>();
            //list.add(nums[i]);
            search(nums, new ArrayList<>(list), i);
            
        }

    }
}