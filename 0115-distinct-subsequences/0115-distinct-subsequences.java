class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m+1][n+1];
        for(int i = 0;i<=m;i++){
            // dp[0][i] = 0; // s is empty them it can make subsequence and this is before written because dp[0][0] = 1 will overrid ein nexr line by dp[i][0] = 1; not needed as in java by default values are 0
            dp[i][0] = 1;  // t is empty that can be made by just one empty string
        }
        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]);// choose and skip both as we can have multiple subsequence
                }else{
                    dp[i][j] = dp[i-1][j];//skip
                }
            }
        }
        return dp[m][n];
    }
}