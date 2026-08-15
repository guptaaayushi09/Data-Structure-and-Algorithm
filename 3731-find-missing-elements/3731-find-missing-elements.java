class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> st = new HashSet<>();
        int mn = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;

        for(int i:nums){
            st.add(i);
            mn = Math.min(mn,i);
            mx = Math.max(mx,i);
        }
        for(int i = mn+1;i<mx;i++){
            if(!st.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}