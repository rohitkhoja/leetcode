class Solution {
    public int longestSubarray(int[] nums) {
        int lastIndex = 0;
        List<Integer> listI = new ArrayList<>();
        List<Integer> listJ = new ArrayList<>();
        if(nums.length==1) return 1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<=nums[i+1]){
                lastIndex = i;
                while(i+1<nums.length && nums[i]<=nums[i+1]){
                    i++;
                }
                
                listI.add(lastIndex);
                listJ.add(i);
                System.out.println(lastIndex+".."+i);
               
            }
        }
        int result = Integer.MIN_VALUE;
        int n = listI.size();
        if(n==0) return 2;
        
        for(int i=0;i<n;i++){
            if(i+1<n && listJ.get(i)+1==listI.get(i+1) 
               && (nums[listJ.get(i)-1] <= nums[listI.get(i+1)]
                  || nums[listJ.get(i)] <= nums[listI.get(i+1)+1])){
                result = Math.max(result,listJ.get(i+1) - listI.get(i)+1 );
                //System.out.println(result);
            }
            if(i+1<n && listJ.get(i)+2==listI.get(i+1) 
               && nums[listJ.get(i)] <= nums[listI.get(i+1)]){
                result = Math.max(result,listJ.get(i+1) - listI.get(i)+1 );
            }
            //System.out.println(listJ.get(i)+".."+listI.get(i));
            result = Math.max(result,listJ.get(i) - listI.get(i)+2 );
            
        }
        
        if(result>nums.length) return nums.length;
        return result;
        
    }
}