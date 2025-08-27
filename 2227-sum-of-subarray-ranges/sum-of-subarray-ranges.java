import java.util.*;

class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;

        Stack<Integer> st = new Stack<>();

        // Contribution as MIN
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] > nums[i])) {
                int j = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;
                long count = (long)(j - left) * (right - j);
                ans -= (long)nums[j] * count; // subtract contribution as min
            }
            st.push(i);
        }

        st.clear();

        // Contribution as MAX
        for (int i = 0; i <= n; i++) {
            while (!st.isEmpty() && (i == n || nums[st.peek()] < nums[i])) {
                int j = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;
                long count = (long)(j - left) * (right - j);
                ans += (long)nums[j] * count; // add contribution as max
            }
            st.push(i);
        }

        return ans;
    }
}
