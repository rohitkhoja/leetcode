class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        //Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        search(candidates, target, list, 0);
        return result;

    }

    public void search(int[] candidates, int target, List<Integer> list, int index){
        if(target==0){
            result.add(new ArrayList<>(list));
            return;
        }
        if(target<0) return;
        for(int i=index; i<candidates.length; i++){
            //if(candidates[i]>target) return;
            list.add(candidates[i]);
            search(candidates, target-candidates[i], list, i);
            list.remove(list.size()-1);
        }

    }

    
    
}