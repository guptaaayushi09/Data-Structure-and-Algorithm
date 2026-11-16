class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] before = new int[n];
        int[] after = new int[n];
        before[0] = 1;

        for(int i =1;i<n;i++){
            before[i] = before[i-1]*nums[i-1];
        }
        after[n-1] = 1;
        for(int i = n-2;i >=0;i--){
            after[i] = after[i+1] * nums[i+1];
        }

        int[] ans = new int[n];
        for(int i = 0;i<n;i++){
            ans[i] = before[i]* after[i];
        }
        return ans;
    }
}