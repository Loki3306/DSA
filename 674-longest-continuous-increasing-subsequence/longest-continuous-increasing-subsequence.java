class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i=1;i<n;i++){
            if(nums[i] > nums[i-1]) dp[i] = 1 + dp[i-1];

            max = Math.max(max,dp[i]);
        }

        return max;
    }
}