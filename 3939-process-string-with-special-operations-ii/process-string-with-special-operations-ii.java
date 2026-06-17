class Solution {
    public char processStr(String s, long k) {

        int n = s.length();
        long[] len = new long[n + 1];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '*') {
                len[i + 1] = Math.max(0, len[i] - 1);
            } else if (c == '#') {
                len[i + 1] = Math.min(Long.MAX_VALUE / 2, len[i] * 2);
            } else if (c == '%') {
                len[i + 1] = len[i];
            } else {
                len[i + 1] = len[i] + 1;
            }
        }

        if (k >= len[n]) {
            return '.';
        }

        for (int i = n - 1; i >= 0; i--) {

            char c = s.charAt(i);

            if (c == '#') {
                long oldLen = len[i];
                k %= oldLen;
            }

            else if (c == '%') {
                long oldLen = len[i];
                k = oldLen - 1 - k;
            }

            else if (c == '*') {
                long oldLen = len[i];

                if (k == oldLen - 1) {
                    return '.';
                }
            }

            else {
                long oldLen = len[i];

                if (k == oldLen) {
                    return c;
                }
            }
        }

        return '.';
    }
}