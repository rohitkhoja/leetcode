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
        return search(grid, 0, 0, grid.length-1, grid[0].length-1);
    }

    public Node search(int[][] grid, int i, int j, int m, int n){
        if(m==i) return new Node(grid[i][j]==1 ? true : false, true);
        System.out.println(i+".."+m);
        System.out.println(j+".."+n);
        Node node1 = search(grid, i, j, (i+m)/2, (j+n)/2 );
        Node node2 = search(grid, i, (j+n)/2+1, (i+m)/2, n);
        Node node3 = search(grid, (i+m)/2+1, j, m, (j+n)/2);
        Node node4 = search(grid, (i+m)/2+1, (j+n)/2+1, m, n);
       
        if(node1.val && node2.val && node3.val && node4.val
                && node1.isLeaf && node2.isLeaf && node3.isLeaf && node4.isLeaf){
            //System.out.println(node1.val);
            return new Node(true, true);
        }
        else if(!node1.val && !node2.val && !node3.val && !node4.val
                && node1.isLeaf && node2.isLeaf && node3.isLeaf && node4.isLeaf){
             //System.out.println(node1.val);
            return new Node(false, true);
        }
        else {
            //System.out.println("diff");
            return new Node(true, false, node1, node2, node3, node4);
        }
    }
}