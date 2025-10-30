class Solution {
     List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();

        search(nums, new ArrayList<>());
        return result;
    }

    public void search(int[] nums, List<Integer> list){

        if(list.size()==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=-11){
                int temp = nums[i];
                list.add(temp);
                nums[i]=-11;
                search(nums, list);
                nums[i]=temp;
                list.remove(list.size()-1);
            }
        }
    }
}