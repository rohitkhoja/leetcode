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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int h = -1;
        int nodes =0;
        TreeNode temp = root;
        while(temp!=null){
            temp = temp.left;
            h++;
        }
        nodes = (int) Math.pow(2,h) -1;
        int height = h;
        h=-1;
        temp = root;
        while(temp!=null){
            temp = temp.right;
            h++;
        }
        if(h==height) return nodes+ (int) Math.pow(2,h);
        h = height;
        
        while(root.right!=null){
            int h1 = calcHeight(root.left,true);
            int h2 = calcHeight(root.left,false);
            if(h1!=h2) {
                root = root.left;
                h--;
            }
            else{
                h--;
                nodes  = nodes + (int) Math.pow(2,h);
                
                h1 = calcHeight(root.right,true);
                h2 = calcHeight(root.right,false);
                if(h1==h2) 
                    return nodes;
                else {
                    root = root.right;
                }
            }
        }
        return nodes+1;

    }
    public int calcHeight(TreeNode root, boolean dir){
        int h = 0;
        if(dir){
            while(root!=null){
                root = root.left;
                h++;
            }
        }
        else{
            while(root!=null){
                root = root.right;
                h++;
            }
        }
        return h;

    }
}