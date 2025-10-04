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
    public void flatten(TreeNode root) {
        
        if(root!=null){
            TreeNode right = root.right;
            if(root.left!=null){
                flatten(root.left);
                root.right = root.left;
                root.left = null;
                while(root.right!=null) root = root.right;
            }
            if(right!=null){
                flatten(right);
                root.right = right;
            }
        }

    }
}