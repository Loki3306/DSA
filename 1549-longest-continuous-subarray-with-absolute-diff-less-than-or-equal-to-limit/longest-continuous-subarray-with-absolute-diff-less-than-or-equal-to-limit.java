import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {

        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();


        int left = 0, ans = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!max.isEmpty() && nums[right] > max.peekLast()) {
                max.pollLast();
            }

            max.addLast(nums[right]);
            while (!min.isEmpty() && nums[right] < min.peekLast()) {
                min.pollLast();
            }

            min.addLast(nums[right]);
            while (max.peekFirst() - min.peekFirst() > limit) {
                if (nums[left] == max.peekFirst()) {
                    max.pollFirst();
                }
                if (nums[left] == min.peekFirst()) {
                    min.pollFirst();
                }
                left++;
            }
            
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
