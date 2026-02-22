class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1=Integer.MAX_VALUE;
        int num2=Integer.MAX_VALUE;
        int count1=0;
        int count2=0;

        List<Integer> list = new ArrayList<>();
        for(int num:nums){
            //if(count1==0) num1 = num;
            if(num==num1) count1++;
            else if(num==num2) count2++;
            else if(count1==0) {
                num1 = num;
                count1++;
            }
            else if(count2==0) {
                num2=num;
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int num:nums){
            
            if(num==num1) count1++;
            if(num==num2) count2++;
            
        }
        int n = nums.length;

        if(count1>n/3) list.add(num1);
        if(count2>n/3) list.add(num2);

        return list;
        
    }
}