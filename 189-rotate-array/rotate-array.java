class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) return;
        k %= n;
        if (k == 0) return;

        // reverse whole array
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        // reverse first k elements
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

        // reverse remaining n-k elements
        for (int i = k, j = n - 1; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
