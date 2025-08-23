class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long mod = (long)1e9 + 7;
        long ans = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        // Compute left[]
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) count++;
                else break;
            }
            left[i] = count;
        }

        // Compute right[]
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] >= arr[i]) count++;
                else break;
            }
            right[i] = count;
        }

        // Final sum
        for (int i = 0; i < n; i++) {
            ans = (ans + (long)arr[i] * left[i] * right[i]) % mod;
        }

        return (int)ans;
    }
}
