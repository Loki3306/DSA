import java.util.*;

class Solution {
    public int largestRectangleArea(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();

        // nearest smaller to left
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // nearest smaller to right
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int maxArea = 0;

        // compute max area
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = nums[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
