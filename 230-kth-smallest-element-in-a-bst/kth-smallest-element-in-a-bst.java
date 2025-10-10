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
    int k;
    int value;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        this.value = 0;
        inorder(root);
        return value;
        
    }

    public boolean inorder(TreeNode root){
        if(root==null) return false;
        if(inorder(root.left)) return true;
        if(k==1) {
            value = root.val;
            return true;
        }
        k--;
        if(inorder(root.right)) return true;
        return false;

    }
}