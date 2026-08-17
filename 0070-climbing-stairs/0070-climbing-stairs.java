class Solution {
    private int[] dp;
    private static int helper(int n , int[] dp){
        if(n <=2) return n;
        if(dp[n] != 0) return dp[n];
        dp[n] = helper(n-1,dp) + helper(n-2,dp);
        return dp[n];
    }
    public int climbStairs(int n) {
        dp = new int[n+1];
        int ways = helper(n,dp);
        return ways;
    }
}