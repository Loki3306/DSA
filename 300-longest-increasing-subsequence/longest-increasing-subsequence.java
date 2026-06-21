class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length + 1];
        int n = nums.length;
        int[] curr = new int[n+1];
        int[] next = new int[n+1];
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int last = ind - 1; last >= -1; last--) {

                int notTake = next[last+1];

                int take = 0;
                if (last == -1 || nums[ind] > nums[last]) {
                    take = 1 + next[ind+1];
                }

                curr[last+1] = Math.max(notTake, take);
            }
            next = curr;
        }

        return curr[0];
    }

}
