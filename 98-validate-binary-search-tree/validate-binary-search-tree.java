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
    long last;
    public boolean isValidBST(TreeNode root) {
        
        last = Long.MIN_VALUE;
        if(!inorder(root)) return false;
        return true;
        
    }

    public boolean inorder(TreeNode root){
        if(root==null) return true;
        if(!inorder(root.left)) return false;
        if(last>=root.val) return false;
        else last = root.val;
        
        if(!inorder(root.right)) return false;
        return true;
    }
}
