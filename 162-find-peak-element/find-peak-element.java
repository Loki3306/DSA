class Solution {
    public int findPeakElement(int[] nums) {
        return binary(nums, 0, nums.length - 1);
    }

    public int binary(int[] nums, int s, int e) {
        while (s < e) {
            int m = s + (e - s) / 2;

            if (nums[m] > nums[m + 1]) {
                e = m;
            } else {
                s = m + 1;
            }
        }
        return s;
    }
}
