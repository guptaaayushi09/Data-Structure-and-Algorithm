/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
       // target value 
       // go k distance  -> down -> up ?
       // convert it into graph -> then start from target -> go bfs till k depth 
       List<Integer> result = new ArrayList<>();
       if(root == null) return result;
       Map<TreeNode, TreeNode> parentMap = new HashMap<>();

       populateParentMap(root,parentMap);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        int currDis = 0;
        while(!queue.isEmpty()){
            if(currDis == k){
                for(TreeNode node : queue){
                    result.add(node.val);
                }
                return result;
            }

            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode current = queue.poll();
                if(current.left != null && !visited.contains(current.left)){
                    visited.add(current.left);
                    queue.offer(current.left);
                }
                if(current.right != null && !visited.contains(current.right)){
                    visited.add(current.right);
                    queue.offer(current.right);
                }

               TreeNode parent = parentMap.get(current);
               if(parent != null && !visited.contains(parent)){
                visited.add(parent);
                queue.offer(parent);
               }

            }
             currDis++;
        }
        return result;

    }
    private void populateParentMap(TreeNode root, Map<TreeNode,TreeNode> parentMap){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            if(current.left != null) {
                parentMap.put(current.left, current);
                queue.offer(current.left);

            }
            if(current.right != null){
                parentMap.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }
}