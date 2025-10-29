class Solution {
    public int smallestNumber(int n) {
        int toggle = 1;
        while (toggle <= n) {
            if ((n & toggle) == 0)
                n = n | toggle;
            toggle = toggle << 1;
        }
        return n;
    }
}
