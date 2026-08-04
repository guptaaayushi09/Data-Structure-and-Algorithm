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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Deque<TreeNode> s1 = new ArrayDeque<>();
        Deque<TreeNode> s2 = new ArrayDeque<>();
        pushLeft(s1,root1);
        pushRight(s2,root2);
        while(!s1.isEmpty() && !s2.isEmpty()){
            TreeNode small = s1.peek();
            TreeNode large = s2.peek();
            int sum = small.val + large.val;
            if(sum == target) return true;
            if(sum <target){
                s1.pop();
                pushLeft(s1,small.right);
            }else{
                    s2.pop();
                    pushRight(s2,large.left);
            }
        }
        return false;

    }
    private void pushLeft(Deque<TreeNode> s1, TreeNode n){
        while(n!= null){
            s1.push(n);
            n= n.left;
        }
    }
    private void pushRight(Deque<TreeNode> s2, TreeNode n){
        while(n!= null){
            s2.push(n);
            n = n.right;
        }
    }
}