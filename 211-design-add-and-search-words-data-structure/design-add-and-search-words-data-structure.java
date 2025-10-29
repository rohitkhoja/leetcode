class WordDictionary {

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;;
    }
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            node = node.children.computeIfAbsent(ch, k -> new TrieNode());
        }
        node.isWord = true;
        
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        char[] ca = word.toCharArray();
        for(int i=0;i<ca.length;i++){
            if(ca[i]=='.'){
                if(searchPartial(node, word.substring(i+1,ca.length))) return true;
                else return false;
            }
            else {
                node = node.children.get(ca[i]);
                if(node==null) return false;
            }
           
        }
        return node.isWord;
        
    }

    public boolean searchPartial(TrieNode n, String word){
        List<TrieNode> set = new ArrayList<>(n.children.values());
        
        for(TrieNode node: set){
            char[] ca = word.toCharArray();
            int i=0;
            for(i=0;i<ca.length;i++){
                if(ca[i]=='.'){
                    if(searchPartial(node, word.substring(i+1,ca.length))) return true;
                    else break;
                }
                else {
                    node = node.children.get(ca[i]);
                    if(node==null) break;
                }
            }
            if(i==ca.length && node.isWord) return true;
            
        }
        return false;

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */