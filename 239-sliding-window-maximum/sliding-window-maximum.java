class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (k == 1) return nums;
        int[] ans = new int[n - k + 1];

        // find max in the first window
        int max = Integer.MIN_VALUE, ind = 0;
        for (int i = 0; i < k; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                ind = i;
            }
        }
        ans[0] = max;

        // slide the window
        for (int i = 1; i < ans.length; i++) {
            int end = i + k - 1;

            if (ind >= i) { // old max still in window
                if (nums[end] >= max) { // new element beats it
                    max = nums[end];
                    ind = end;
                }
            } else { // old max slid out, must recompute
                max = Integer.MIN_VALUE;
                for (int j = i; j <= end; j++) {
                    if (nums[j] >= max) {
                        max = nums[j];
                        ind = j;
                    }
                }
            }
            ans[i] = max;
        }
        return ans;
    }
}
