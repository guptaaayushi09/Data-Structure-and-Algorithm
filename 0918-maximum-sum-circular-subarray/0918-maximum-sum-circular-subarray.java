class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
       
        // what is the stopping point?
        //
        int currMax= 0;
        int currMin = 0;

        int maxSum = nums[0];
        int totalSum = 0;
        int minSum = nums[0];

        for(int i = 0;i<n;i++){
            currMax = Math.max(0 , currMax) + nums[i];
            maxSum = Math.max(currMax, maxSum);

            currMin  = Math.min(currMin, 0) + nums[i];
            minSum = Math.min(currMin,minSum);

            totalSum += nums[i];
        }
        if(totalSum == minSum ) return maxSum;

        return Math.max(maxSum, totalSum-minSum);
        
    }
}