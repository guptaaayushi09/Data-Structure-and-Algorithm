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
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        TreeNode start = buildParentMap(root,k,parentMap);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();

        queue.offer(start);
        seen.add(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left ==null && node.right ==null) return node.val;
                    
                if(node.left != null && !seen.contains(node.left)){
                    queue.offer(node.left);
                    seen.add(node.left);
                }
                if(node.right != null && !seen.contains(node.right)){
                    queue.offer(node.right);
                    seen.add(node.right);
                }
                TreeNode parent = parentMap.get(node);
                if(parent != null && !seen.contains(parent)){
                    queue.offer(parent);
                    seen.add(parent);
                }
            }
        }
        return -1;

    }

    private TreeNode buildParentMap(TreeNode root, int k , Map<TreeNode,TreeNode> mp){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode target=null;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i =0;i<n;i++){
                TreeNode node = q.poll();
                if(node.val == k) target = node;

                if(node.left!= null){
                    mp.put(node.left,node);
                    q.offer(node.left);
                }
                if(node.right != null){
                    mp.put(node.right,node);
                    q.offer(node.right);
                }
            }
        }
        return target;
    }
}