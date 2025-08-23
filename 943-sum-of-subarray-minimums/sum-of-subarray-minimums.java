class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long mod = (long)1e9 + 7;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<int[]> st = new Stack<>();

        // Left span: strictly greater
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (!st.isEmpty() && st.peek()[0] > arr[i]) {
                count += st.pop()[1];
            }
            left[i] = count;
            st.push(new int[]{arr[i], count});
        }

        st.clear();

        // Right span: greater or equal
        for (int i = n - 1; i >= 0; i--) {
            int count = 1;
            while (!st.isEmpty() && st.peek()[0] >= arr[i]) {
                count += st.pop()[1];
            }
            right[i] = count;
            st.push(new int[]{arr[i], count});
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long)arr[i] * left[i] * right[i]) % mod;
        }

        return (int)ans;
    }
}
