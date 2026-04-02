class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {

        Arrays.sort(nums);
        //Arrays.sort(queries);
        int m = queries.length;
        int n = nums.length;

        int[] answers = new int[m];

        for(int i=0;i<m;i++){
            int test = queries[i];
            int temp = 0;
            int j=0;
            for(j=0;j<n;j++){
                temp += nums[j];
                if(temp>test) break;
            }

            answers[i] = j;

        }
        return answers;
        
    }
}