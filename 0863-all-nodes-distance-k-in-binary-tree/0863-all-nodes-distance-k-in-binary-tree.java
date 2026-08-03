
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        populateParentMap(root,parentMap);

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(target);
        visited.add(target);
        int currDis = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            if(currDis == k){
                for(int i = 0;i<size;i++){
                    result.add(queue.poll().val);
                }
                return result;
            }
            for(int i = 0;i<size;i++){
               TreeNode current = queue.poll();
               if(current.left != null && !visited.contains(current.left)){
                    queue.offer(current.left);
                    visited.add(current.left);
               }
               if(current.right != null && !visited.contains(current.right)){
                    queue.offer(current.right);
                    visited.add(current.right);
               }

              TreeNode parent = parentMap.get(current);
              if(parent != null && !visited.contains(parent)){
                queue.offer(parent);
                visited.add(parent);
              }
            }
            currDis++;
        }
        return result;
     }
     private void populateParentMap(TreeNode root, Map<TreeNode, TreeNode> map){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
          int size = queue.size();

          for(int i =0;i<size;i++){
            TreeNode current = queue.poll();
            if(current.left != null){
                queue.offer(current.left);
                map.put(current.left, current);
            }
            if(current.right != null){
                queue.offer(current.right);
                map.put(current.right, current);
            }
          }
        }
     }
}