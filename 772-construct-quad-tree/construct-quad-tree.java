/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return constructQuadTree(grid, 0, n-1, 0, n-1);
    }

    public Node constructQuadTree(int[][] grid, int m, int m1, int n, int n1) {

        if(m==m1 && n==n1) return new Node(grid[m][n]==1,true);
        Node tl = constructQuadTree(grid, m, (m1+m)/2, n, (n1+n)/2);
        Node bl = constructQuadTree(grid, (m1+m)/2+1, m1, n, (n1+n)/2);
        Node tr = constructQuadTree(grid, m, (m1+m)/2, (n1+n)/2+1, n1);
        Node br = constructQuadTree(grid, (m1+m)/2+1, m1, (n1+n)/2+1, n1);

        if(tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf 
            && tl.val==tr.val && tl.val==bl.val && tl.val==br.val)
            return new Node(tl.val,true);

        else return new Node(true, false, tl, tr, bl, br);
        
    }

    
}