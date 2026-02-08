/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(treeHeight(root)==-1) return false;
        return true;
    }

    public int treeHeight(TreeNode root){
        if(root==null) return 0;
        int h1 = treeHeight(root.left);
        int h2 = treeHeight(root.right);
        if(h1==-1 || h2==-1) return -1;
        if(Math.abs(h1-h2)>1) return -1;
        return Math.max(h1,h2)+1;
    }
}