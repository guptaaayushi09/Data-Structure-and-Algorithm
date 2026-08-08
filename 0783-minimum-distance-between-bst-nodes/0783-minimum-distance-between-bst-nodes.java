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
    int minDis = Integer.MAX_VALUE;
    TreeNode prevValue;
    public int minDiffInBST(TreeNode root) {
        //inorder -> consecutive diff
        //while inorder ->consecutive 
        inorderT(root);
        return minDis;

    }
    private void inorderT(TreeNode root){
        if(root ==null) return ;
        inorderT(root.left);
        if(prevValue != null){
            minDis = Math.min(minDis,root.val-prevValue.val);//root.val will still be greater than prevValue.val because of how in-order traversal visits the nodes
            
        }
        prevValue = root;
        inorderT(root.right);
    }
}