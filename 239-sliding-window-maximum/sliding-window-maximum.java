class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int n = nums.length;
        if (k == 1) return nums;  
        
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0;

        for (int i = 0; i < n; i++) {
            
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();

            
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();

            dq.offerLast(i);

            if (i >= k - 1) ans[idx++] = nums[dq.peekFirst()];
        }

        return ans;
    }
}
