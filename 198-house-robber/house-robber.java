class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[1],nums[0]);

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];

        for(int i=2;i<n;i++){
            dp[i] = Integer.MIN_VALUE;

            for(int j=i-2;j>=0;j--){
                dp[i] = Math.max(dp[j],dp[i]);
            }

            dp[i] += nums[i];
        }

        int max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            max = Math.max(max,dp[i]);
        }

        return max;
    }
}