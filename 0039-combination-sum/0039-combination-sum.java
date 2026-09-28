class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        generateCombination(candidates,target, 0, ans,new ArrayList<>());
        return ans;
    }
    private static void generateCombination(int[] candidates, int target, int index,  List<List<Integer>> ans, List<Integer>currentList){
        if(target == 0){
            ans.add(new ArrayList<>(currentList));
            return;
        }
        if(index == candidates.length || target < 0){
            return;
        }
        if(candidates[index]<=target){ // [pick only if less than]
            currentList.add(candidates[index]);
            generateCombination(candidates, target - candidates[index], index,ans,currentList); // can pick as many as times we want
            currentList.remove(currentList.size()-1);
        }
        //not pick
        generateCombination(candidates, target, index+1,ans,currentList);
        

    }
}