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
        List<String> sList = pathExplore(root);
        int sum = 0;
        for(String s: sList){
            sum += Integer.valueOf(s);
        }
        return sum;
        
        
    }
    
    public List<String> pathExplore(TreeNode root){
        if(root==null) return new ArrayList<>();
        List<String> nodePathList = new ArrayList<>();
        if(root.left!=null){
            List<String> sList = pathExplore(root.left);
            for(String s: sList){
                nodePathList.add(Integer.toString(root.val)+s);
            }
        }
        if(root.right!=null){
            List<String> sList = pathExplore(root.right);
            for(String s: sList){
                nodePathList.add(Integer.toString(root.val)+s);
            }
        }
        if(root.left==null && root.right==null){
            nodePathList.add(Integer.toString(root.val));
        }
        return nodePathList;
     }
}