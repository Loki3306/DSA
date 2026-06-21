class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length + 1];
        int n = nums.length;
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int last = ind - 1; last >= -1; last--) {

                int notTake = dp[ind+1][last+1];

                int take = 0;
                if (last == -1 || nums[ind] > nums[last]) {
                    take = 1 + dp[ind+1][ind+1];
                }

                dp[ind][last+1] = Math.max(notTake, take);
            }
        }

        return dp[0][0];
    }

}
