class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        int n = piles.length;
        for(int i=0;i<n;i++){
            max = Math.max(max, piles[i]);
        }

        return  binaryrarch(1, max,piles,h);


    }
    
    public int binaryrarch(int l, int r, int[] piles, int h){
        if(l>r){
            return l;
        }
        int mid = (l+r)/2;

        long hours = requiredHours(piles, mid);
        if(hours<=h) return binaryrarch(l,mid-1,piles, h);
        else return binaryrarch(mid+1,r,piles, h);
        //else return mid;

    }

    public long requiredHours(int[] piles, int k){
            long hours = 0;
            for(int i=0;i<piles.length;i++){
                hours += (long) (piles[i]+k-1)/k;
            }
            return hours;
    }
}