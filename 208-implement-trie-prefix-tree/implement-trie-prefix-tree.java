class Trie {

    Set<String> set;
    Set<String> full;
    public Trie() {
        set = new HashSet<>();
        full = new HashSet<>();
    }
    
    public void insert(String word) {
        char[] chars = word.toCharArray();
        String s = "";
        for(int i=0;i<chars.length;i++){
            s +=  chars[i];
            set.add(s);
        }
        full.add(word);
    }
    
    public boolean search(String word) {
        if(full.contains(word)) return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        if(set.contains(prefix)) return true;
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */