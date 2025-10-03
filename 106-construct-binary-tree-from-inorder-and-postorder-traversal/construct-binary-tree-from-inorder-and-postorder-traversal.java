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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        int l = postorder.length;
        TreeNode root = new TreeNode(postorder[l-1]);
        stack.push(root);
        for(int i=l-2;i>=0;i--){
            TreeNode temp = new TreeNode(postorder[i]);
            int index = map.get(postorder[i]);
            if(index>map.get(stack.peek().val)){
                stack.peek().right = temp;
            }
            else{
                TreeNode temp1 = null;
                while(!stack.isEmpty() && index<map.get(stack.peek().val)) 
                    temp1 = stack.pop();
                temp1.left = temp;    
            }
            stack.push(temp);
        }    
        return root;

    }
}