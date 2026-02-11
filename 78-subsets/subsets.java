class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {

        result = new ArrayList<>();
        Arrays.sort(nums);
        result.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            addSet(i+1, nums, list);
            // System.out.println(result);
            // System.out.println(i);

            
        }

        return result;
        
    }

    public void addSet(int index, int[] nums, List<Integer> list){
            
            for(int j=index;j<nums.length;j++){
                list.add(nums[j]);
                result.add(new ArrayList<>(list));
                // System.out.println(result);
                // System.out.println(index);
                addSet(j+1, nums, list);
                list.remove(list.size()-1);
            }
            

    }

}




