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

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
       maxSum(root);
       return maxSum;
    }

    public int maxSum(TreeNode root){

        if(root==null) return 0;
        int ls = maxSum(root.left);
        int rs = maxSum(root.right);
        int leftSum = ls>0 ? ls : 0;
        int rightSum = rs>0 ? rs : 0;


        if(root.val+leftSum+rightSum > maxSum) maxSum = root.val+leftSum+rightSum;

        if(leftSum>rightSum ) return root.val+leftSum;
        else return root.val+rightSum;


    }

}