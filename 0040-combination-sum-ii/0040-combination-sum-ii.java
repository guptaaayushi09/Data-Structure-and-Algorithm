class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates); 
        generateCombi(candidates,target, 0, new ArrayList<>(), ans);
        return ans;
    }
    private static void generateCombi(int[] candidates, int target, int index, List<Integer> currentList,List<List<Integer>> ans ){
            if(target == 0){
                ans.add(new ArrayList<>(currentList));
                return ;
            }
           for(int i = index;i<candidates.length;i++){
            if(candidates[i] > target) break; // already greater and sorted to further will not add
            if(i > index && candidates[i] == candidates[i-1]) continue; // cant add duplicate
            currentList.add(candidates[i]);
             generateCombi(candidates,target-candidates[i], i+1, currentList, ans);
             currentList.remove(currentList.size()-1);
           }
    }
}