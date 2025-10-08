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
    public int getMinimumDifference(TreeNode root) {
        int[] diff = new int[1];
        diff[0] = Integer.MAX_VALUE;
        checkMinimumDiff(root, diff);
        return diff[0];
    }
    public void checkMinimumDiff(TreeNode root, int[] diff){
        if(root==null || (root.left==null && root.right == null )) return;
        if(root.left!=null){
            int n = nextLargeL(root.left);
            if(root.val - n < diff[0])
                diff[0]  = root.val-n;
        } 
        if(root.right!=null){
            int n = nextLargeR(root.right);
            if( n - root.val < diff[0])
                diff[0]  = n - root.val;
        } 
        
        checkMinimumDiff(root.left, diff);
        checkMinimumDiff(root.right, diff);
    }
    public int nextLargeR(TreeNode root){
       int n = root.val;
       while(root.left!=null){
            root = root.left;
            n = root.val;
       }
       return n;
    }
    public int nextLargeL(TreeNode root){
        int n = root.val;
       while(root.right!=null){
            root = root.right;
            n = root.val;
       }
       return n;
    }
}