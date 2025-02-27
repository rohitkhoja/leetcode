class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer,Integer> elements = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(elements.containsKey(nums[i])) elements.put(nums[i],elements.get(nums[i])+1);
            else elements.put(nums[i],1);
        }
        System.out.println(elements);
        Set<List<Integer>> check = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        for(int j=i+1;j<nums.length;j++){
            if(nums[i]==0 && nums[j]==0 && elements.get(nums[i]) > 2){
                    List<Integer> temp = 
                    new ArrayList<>(List.of(nums[i],nums[j],-(nums[i]+nums[j])));
                Collections.sort(temp);
                if(!check.contains(temp)){
                    check.add(temp);
                    result.add(temp);
                }
            }
            else if((nums[i]+nums[j] == -(nums[i])) && elements.get(nums[i]) >=2 && !(nums[i]==nums[j])){
                List<Integer> temp = 
                    new ArrayList<>(List.of(nums[i],nums[j],-(nums[i]+nums[j])));
                Collections.sort(temp);
                if(!check.contains(temp)){
                    check.add(temp);
                    result.add(temp);
                }
            }
            else if((nums[i]+nums[j] == -(nums[j]))&& elements.get(nums[j]) >=2 && !(nums[i]==nums[j])){
                List<Integer> temp = 
                    new ArrayList<>(List.of(nums[i],nums[j],-(nums[i]+nums[j])));
                Collections.sort(temp);
                if(!check.contains(temp)){
                    check.add(temp);
                    result.add(temp);
                }
            }
               
            else if(elements.containsKey(-(nums[i]+nums[j])) 
                    && !(nums[i]==nums[j]) && !(nums[i]+nums[j] == -(nums[j])) 
                            && !(nums[i]+nums[j] == -(nums[i]))){
                List<Integer> temp = 
                    new ArrayList<>(List.of(nums[i],nums[j],-(nums[i]+nums[j])));
                Collections.sort(temp);
                if(!check.contains(temp)){
                    check.add(temp);
                    result.add(temp);
                }
            }
            else continue;
             
           
        }
        return result;
    }
}