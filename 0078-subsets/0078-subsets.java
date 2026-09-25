class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generateSubset(nums,ans,0,new ArrayList<>());
        return ans;
    }
    private static void generateSubset(int[] nums,List<List<Integer>> ans,int index,List<Integer> current){
        if(index == nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        generateSubset(nums,ans,index+1,current);
        current.remove(current.size()-1);
        generateSubset(nums,ans,index+1,current);
    }
}