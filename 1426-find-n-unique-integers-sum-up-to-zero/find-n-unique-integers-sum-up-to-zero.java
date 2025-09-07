class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        if (n % 2 == 0) {
            int can = n;
            boolean pos = true;
            for (int i = 0; i < n; i++) {
                if (pos) {
                    ans[i] = can;
                    pos = false;
                } else {
                    ans[i] = -can;
                    pos = true;
                    can -= 1;
                }

            }
        } else {
            int can = n;
            boolean pos = true;
            for (int i = 0; i < n - 1; i++) {
                if (pos) {
                    ans[i] = can;
                    pos = false;
                } else {
                    ans[i] = -can;
                    pos = true;
                    can -= 1;
                }
            }
            ans[n - 1] = 0;
        }

        return ans;
    }
}