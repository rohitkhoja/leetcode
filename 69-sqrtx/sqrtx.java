class Solution {
    public int mySqrt(int x) {
        return (int) binarySearch(0,x,x);
    }

    public long binarySearch(long start, long end, long target){
        if(start>end){
            return end;
        }

        long mid = (start+end)/2;
        //System.out.println(mid);
        if(target== (long) mid*mid) return mid;
        if(target > (long) (mid*mid) && target < (long) (mid+1)*(mid+1)) return mid;
        if(target > (long) (mid*mid)) return binarySearch(mid+1, end, target);
        else return binarySearch(start, mid-1, target);

    }
}