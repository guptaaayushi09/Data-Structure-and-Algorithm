class Solution {
    public int totalSteps(int[] nums) {
        // we have to count the number of iteration required to remove the and reach till the point left is < than right or right is greater than left
        int n = nums.length;
        int ans = 0;
        Stack<Pair<Integer,Integer>> st = new Stack<>();
        st.push(new Pair(nums[n-1],0));
        for(int i = n-2;i>=0;i--){
            int count = 0; // for every index it should be new count
            while(!st.isEmpty() && nums[i] > st.peek().getKey()){
                count = Math.max(count +1, st.peek().getValue());
                st.pop();
            }
            ans = Math.max(ans,count);
             st.push(new Pair(nums[i],count));
         }
     return ans;
    }
}