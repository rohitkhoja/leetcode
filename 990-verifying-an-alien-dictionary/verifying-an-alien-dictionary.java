class Solution {

    Map<Character, Integer> map;
    public boolean isAlienSorted(String[] words, String order) {


        map = new HashMap<>();
        int i=1;
        for(char c: order.toCharArray()){
            map.put(c,i);
            i++;
        }
        int n = words.length;

        for(i=0;i<n;i++){
            String s1 = words[i];
            for(int j=i+1;j<n;j++){
                if(!compareString(s1,words[j])) return false;
            }
        }

        return true;
        
    }

    public boolean compareString(String a, String b){
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        int l1 = s1.length;
        int l2 = s2.length;

        int i=0;
        int j=0;
        while(i<l1 && j<l2 && s1[i]==s2[j]) {
            i++;
            j++;
        }

        if(i==l1) return true;
        if(j==l2) return false;
        if(map.get(s1[i])>map.get(s2[j])) return false;
        return true;
    }
}