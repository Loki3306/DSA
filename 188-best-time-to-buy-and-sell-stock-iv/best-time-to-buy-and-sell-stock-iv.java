class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][k + 1];

        for (int day = prices.length - 1; day >= 0; day--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (buy == 1) {
                        dp[day][buy][cap] = Math.max(
                                -prices[day] + dp[day+1][0][cap],
                                dp[day+1][1][cap]
                        );
                    } else {
                        dp[day][buy][cap] = Math.max(
                                prices[day] + dp[day+1][1][cap-1],
                                dp[day+1][0][cap]
                        );
                    }
                }
            }
        }

        return dp[0][1][k];

    }
}