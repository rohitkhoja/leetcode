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


    class Sum{
        int tSum;
        int fSum;
        public Sum(int tSum, int fSum){
            this.tSum = tSum;
            this.fSum = fSum;
        }
    }
    
    public int rob(TreeNode root) {


        Sum s = calcRob(root);
        return s.tSum>s.fSum ? s.tSum : s.fSum;
    }

    public Sum calcRob(TreeNode root){

        if(root==null) return new Sum(0,0);
        Sum left = calcRob(root.left);
        Sum right = calcRob(root.right);
        
        int tSum = root.val+left.fSum+right.fSum;
        int fSum = Math.max(left.fSum, left.tSum) + Math.max(right.fSum, right.tSum);

        return new Sum(tSum, fSum);
        


    }
}