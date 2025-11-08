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
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayMain(nums, 0, nums.length-1);
    }

    public TreeNode sortedArrayMain(int[] nums, int start, int end){
        //System.out.println(start+"vvv"+end);
        if(start>end) return null;
        if(start==end) return new TreeNode(nums[start]);
        int mid = (start+end)/2;
        //System.out.println(mid);
        return new TreeNode(nums[mid], sortedArrayMain(nums, start, mid-1), sortedArrayMain(nums, mid+1,end) );
    }
}