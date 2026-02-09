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
    List<TreeNode> list;
    public TreeNode balanceBST(TreeNode root) {
        list = new ArrayList<>();
        inorder(root.left);
        list.add(root);
        inorder(root.right);

        int l = list.size();
        int mid = l/2;
        TreeNode temp = list.get(mid);
        temp.left = bst(0,mid-1);
        temp.right = bst(mid+1,l-1);
        return temp;    

    }

    public TreeNode bst(int start, int end){
        if(start>end) return null;
        int mid = (start+end)/2;
        TreeNode temp = list.get(mid);
        temp.left = bst(start, mid-1);
        temp.right = bst(mid+1, end);
        return temp;
    }

    public void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            list.add(root);
            inorder(root.right);
        }
        
    }
}