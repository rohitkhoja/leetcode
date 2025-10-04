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
    public int sumNumbers(TreeNode root) {
        int sum=0;
        int[] totalSum = new int[1];
        totalSum[0] = 0;
        sumOfPath(root, sum, totalSum);
        return totalSum[0];
        
    }
    public void sumOfPath(TreeNode root, int sum, int[] totalSum){
        if(root!=null){
            sum = sum*10 + root.val;
            if(root.left==null && root.right==null){
                totalSum[0] += sum;
            }
            sumOfPath(root.left, sum, totalSum);
            sumOfPath(root.right, sum, totalSum);
        }
        
    }
}