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
    public int maxLevelSum(TreeNode root) {
        if(root==null) return 0;

        Deque<TreeNode> q = new ArrayDeque<>();

        int level = 1;
        int sum  = Integer.MIN_VALUE;
        int resultLevel = 0;

        q.offer(root);
        while(!q.isEmpty()){
            int sz = q.size();
            int levelSum = 0;
            for(int i=0;i<sz;i++){
                TreeNode node = q.poll();
                levelSum += node.val;
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }

            if(levelSum>sum){
                resultLevel = level;
                sum = levelSum;
            }

            level++;
        }
        
        return resultLevel;
    }
}