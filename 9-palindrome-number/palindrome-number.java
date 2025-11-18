class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        List<Integer> list = new ArrayList<>();
        while(x>0){
            list.add(x%10);
            x /= 10;
        }
        //System.out.println(list);
        int i=0;
        int j=list.size()-1;
        while(i<j){
            if(list.get(i)!=list.get(j)) break;
            i++;
            j--;
        }
        // System.out.println(i);
        // System.out.println(j);
        return i>=j;
    }
}