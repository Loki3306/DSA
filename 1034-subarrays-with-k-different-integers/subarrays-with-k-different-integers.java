class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0, left = 0;
        int[] freq = new int[100001]; // adjust max value
        int distinct = 0;

        for (int right = 0; right < n; right++) {
            if (freq[nums[right]] == 0) distinct++;
            freq[nums[right]]++;

            while (distinct > k) {
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) distinct--;
                left++;
            }

            cnt += right - left + 1;
        }

        return cnt;
    }
}
