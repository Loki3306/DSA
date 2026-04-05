class Solution {
    public int uniquePathsWithObstacles(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;

        int[][] dp = new int[n][m];

        boolean free = true;
        for (int i = 0; i < m; i++) {
            if(nums[0][i] == 1) break;
            dp[0][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            if(nums[i][0] == 1) break;
            dp[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(nums[i][j] != 1) dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                else dp[i][j] = 0;
            }
        }

        return dp[n - 1][m - 1];
    }
}