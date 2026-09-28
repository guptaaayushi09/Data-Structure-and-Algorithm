class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permutation(nums,new ArrayList<>(), ans,visited);
        return ans;
    }
    private static void permutation(int[]nums, List<Integer> list,List<List<Integer>> ans ,boolean[] visited)
    {
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
       for(int i =0;i<nums.length;i++){
            if(visited[i]){
                continue;
            }
            list.add(nums[i]);
            visited[i]= true;
            permutation(nums,list,ans,visited);
            list.remove(list.size()-1);
            visited[i] = false;
       }

    }
}