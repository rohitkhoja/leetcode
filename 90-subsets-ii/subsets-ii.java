class Solution {

    Set<List<Integer>> result;
    int n;

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        result = new HashSet<>();
        Arrays.sort(nums);

        result.add(new ArrayList<>());
        n = nums.length;

        for(int i=0;i<n;i++){
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            result.add(list);
            add(list, i+1, nums);
        }
        //System.out.println(result);
        return new ArrayList<>(result);

        
    }

    public void add(List<Integer> list, int index, int[] nums){

        for(int i=index;i<n;i++){
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            add(list, i+1, nums);
            list.remove(list.size()-1);
        }

    }
}