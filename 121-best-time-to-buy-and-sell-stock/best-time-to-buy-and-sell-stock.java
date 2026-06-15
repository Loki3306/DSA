class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[2][n];

        dp[0][0] = 0;
        dp[1][0] = prices[0];

        for(int j=1;j<n;j++){
            dp[0][j] = Math.max(dp[0][j-1],prices[j]-dp[1][j-1]);
            dp[1][j] = Math.min(dp[1][j-1],prices[j]);
        }

        return dp[0][n-1];
    }
}