class Solution {
    public int[] plusOne(int[] digits) {

        int carry = 1;
        int n = digits.length;
        int[] ans = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {

            if (carry == 1) {
                ans[i + 1] = (digits[i] + 1) % 10;

                if (digits[i] == 9) {
                    carry = 1;
                } else {
                    carry = 0;
                }
            } else {
                ans[i + 1] = digits[i];
            }
        }

        if (carry == 1) {
            ans[0] = 1;
            return ans;
        }

        return Arrays.copyOfRange(ans, 1, n + 1);
    }
}