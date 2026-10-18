class Solution {
    public int maxProfit(int[] nums) {
        int min = nums[0];
     int profit = 0;
     for(int i = 1;i< nums.length;i++){
        min = Math.min(nums[i], min);
        profit = Math.max(profit, nums[i]-min);
     }
     return profit;

        
    }
}