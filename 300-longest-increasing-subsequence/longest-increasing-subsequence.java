class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, -1, nums, nums.length, dp);
    }

    public int f(int ind, int last, int[] nums, int n, int[][] dp) {
        if (ind == n)
            return 0;

        if (dp[ind][last + 1] != -1)
            return dp[ind][last + 1];

        int notTake = f(ind + 1, last, nums, n, dp);

        int take = 0;
        if (last == -1 || nums[ind] > nums[last]) {
            take = 1 + f(ind + 1, ind, nums, n, dp);
        }

        return dp[ind][last + 1] = Math.max(take, notTake);
    }
}
