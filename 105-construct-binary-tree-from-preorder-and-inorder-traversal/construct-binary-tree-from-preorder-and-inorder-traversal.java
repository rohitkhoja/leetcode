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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length==0) return null;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        Deque<TreeNode> ndoeStack = new ArrayDeque<>();
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }
        TreeNode root = new TreeNode(preorder[0]);
        ndoeStack.push(root);
        for(int i=1;i<preorder.length;i++){
            TreeNode temp = new TreeNode(preorder[i]);
            int lastNodeIndex = inorderMap.get(ndoeStack.peek().val);
            int currentNodeIndex = inorderMap.get(preorder[i]);
            if(lastNodeIndex > currentNodeIndex){
                ndoeStack.peek().left = temp;
            }
            else{
                TreeNode rightRoot = null;
                while(!ndoeStack.isEmpty() 
                        && inorderMap.get(ndoeStack.peek().val) < currentNodeIndex){
                    rightRoot = ndoeStack.pop();
                }
                rightRoot.right = temp;
            }
            ndoeStack.push(temp);
        }

        return root;
        
    }
}