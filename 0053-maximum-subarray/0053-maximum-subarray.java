class Solution {
    public int maxSubArray(int[] nums) {
        //calculate sum 
        // then ->if any point sum <nums[i] then assign to it and iterate till end
        int currSum = nums[0];
        int maxSum = nums[0];

        for(int i =1;i<nums.length;i++){
            currSum+=nums[i];
            
            currSum = Math.max(nums[i],currSum);

            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }
}