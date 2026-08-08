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

    TreeNode prevNode;
    int minDiff = Integer.MAX_VALUE;
    private void inorderTraversal(TreeNode root){
        if(root == null) return;
        inorderTraversal(root.left);
        if(prevNode != null){
            minDiff = Math.min(minDiff, root.val - prevNode.val);
        }
        prevNode = root;
        inorderTraversal(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        inorderTraversal(root);
        return minDiff;
    }
}