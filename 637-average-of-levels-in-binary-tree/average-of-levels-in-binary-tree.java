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
    public List<Double> averageOfLevels(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Double> result = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int l = q.size();
            double sum = 0;
            for(int i=0;i<l;i++){
                TreeNode node = q.pop();
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
                sum += node.val;
            }
            result.add(sum/l);
        }
        return result;

    }
}