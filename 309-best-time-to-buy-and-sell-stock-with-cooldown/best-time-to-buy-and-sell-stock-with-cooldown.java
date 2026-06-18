class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 2][2];

        for (int day = prices.length - 1; day >= 0; day--) {
            for (int buy = 0; buy < 2; buy++) {
                if (buy == 1) {
                    dp[day][buy] = Math.max(
                            -prices[day] + dp[day + 1][0],
                            dp[day + 1][1]);
                } else {
                    dp[day][buy] = Math.max(
                            prices[day] + dp[day + 2][1],
                            dp[day + 1][0]);
                }

            }
        }

        return dp[0][1];
    }

    // public int f(int day, int buy, int[] nums, int n, int[][] dp) {
    //     if (day >= n)
    //         return 0;
    //     if (dp[day][buy] != -1)
    //         return dp[day][buy];

    //     if (buy == 1) {
    //         dp[day][buy] = Math.max(
    //                 -nums[day] + f(day + 1, 0, nums, n, dp),
    //                 0 + f(day + 1, 1, nums, n, dp));
    //     } else {
    //         dp[day][buy] = Math.max(
    //                 nums[day] + f(day + 2, 1, nums, n, dp),
    //                 f(day + 1, 0, nums, n, dp));
    //     }

    //     return dp[day][buy];
    // }
}