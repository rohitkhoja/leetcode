class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] numberOfCandies = new int[n];
        numberOfCandies[0] = 1;
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]) numberOfCandies[i] = numberOfCandies[i-1]+1;
            else numberOfCandies[i] = 1;
        }
        int result = numberOfCandies[n-1];
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1] && numberOfCandies[i] <= numberOfCandies[i+1]) {
                numberOfCandies[i] = numberOfCandies[i+1]+1;
            }
            result += numberOfCandies[i];
            
        }

        return result;

        
    }
}