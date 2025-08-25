class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long mod = (long)1e9 + 7;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int left = 1;
            int right = 1;


            for (int j = i - 1; j >= 0 && arr[j] > arr[i]; j--) {
                left++;
            }

            
            for (int j = i + 1; j < n && arr[j] >= arr[i]; j++) {
                right++;
            }

            ans = (ans + (long)arr[i] * left * right) % mod;
        }

        return (int)ans;
    }
}
