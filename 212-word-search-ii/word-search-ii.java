class Solution {

    public class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }
    boolean[][] v;
    TrieNode root;
    int n;
    int m;
    int[] x = {1,-1,0,0};
    int[] y = {0,0,1,-1};
    public List<String> findWords(char[][] board, String[] words) {
        n = board.length;
        m = board[0].length;
        v = new boolean[n][m];
        root = new TrieNode();
        for(String word: words){
           TrieNode node = root;
           for(char ch: word.toCharArray()){
                node = node.children.computeIfAbsent(ch, k-> new TrieNode());
            }
            node.isWord = true;
        }
                
        Set<String> result = new HashSet<>();
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++){
                if(root.children.containsKey(board[i][j])){
                    
                    char ch = board[i][j];
                    search( ""+ch, board, i,j, root.children.get(ch), result);
                }
            }

        return new ArrayList<>(result);        
    }

    public void search( String word, char[][] board,int i, int j, TrieNode node, Set<String> result ){
            if(node.isWord) result.add(word);
            
            v[i][j] = true;
            for(int k=0;k<4;k++){
                int x1 = x[k]+i;
                int y1 = y[k]+j;
                if(x1>=0 && x1<n && y1>=0 && y1<m && node.children.containsKey(board[x1][y1])
                    && !v[x1][y1]){
                    char ch = board[x1][y1];
                    search( word+ch, board,x1, y1, node.children.get(ch), result);
                }
            }
             v[i][j] = false;
    }
}