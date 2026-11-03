class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMin = 0;
        int currMax = 0;
        int n = nums.length;
        int maxSum = nums[0];
        int minSum = nums[0];
        int totalSum = 0;

        for(int i =0;i<n;i++){
            currMin = Math.min(currMin,0) +nums[i];
            minSum = Math.min(minSum, currMin);

            currMax = Math.max(currMax,0) +nums[i];
            maxSum = Math.max(currMax,maxSum);

            totalSum +=nums[i];
        }
       
        if(totalSum == minSum ) return maxSum;
        return Math.max(maxSum,totalSum-minSum);
    }
}