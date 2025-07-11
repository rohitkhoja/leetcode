class Solution {
    public boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();
    while(n!=1){
        int n1 = calcNumber(n);
        if(set.contains(n1) || n1==4) return false;
        set.add(n1);
        n=n1;
    }
    return true;
    }
    public int calcNumber(int n){
        int result = 0;
        while(n>0){
            int n1 = n%10;
            result+= n1 * n1;
            n = n/10;
        }
        return result;
    }
}