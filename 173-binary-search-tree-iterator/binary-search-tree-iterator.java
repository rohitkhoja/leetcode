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
class BSTIterator {
     
    TreeNode curr;

    public BSTIterator(TreeNode root) {
        curr = inorderTransform(root);
        // while(root.right!=null){
        //     System.out.println(root.val);
        //     root = root.right;
        // }
    }
    
    public int next() {
       int result = curr.val;
       curr =  curr.right;
       return  result;
    }
    
    public boolean hasNext() {
        return curr!=null;
        
    }

    public TreeNode inorderTransform(TreeNode root){
        if(root==null || (root.left==null && root.right==null)) return root;
        TreeNode temp = root; 
        if(root.left!=null){
            TreeNode left = inorderTransform(root.left);
            temp = left;
            
            while(left.right!=null) left = left.right;
            left.right = root;
        }
        TreeNode right = inorderTransform(root.right);
        root.right = right;
        root = temp;
        return temp;
    }


}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */