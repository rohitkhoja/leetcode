class Trie {

    class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            node = node.children.computeIfAbsent(ch, k -> new TrieNode());
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            node = node.children.get(ch);
            if(node==null) return false;
        }
        return node.isWord;
         
    }
    
    public boolean startsWith(String prefix) {
         TrieNode node = root;
        for(char ch: prefix.toCharArray()){
            node = node.children.get(ch);
            if(node==null) return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */