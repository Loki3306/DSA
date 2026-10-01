class Solution {
    public int mySqrt(int x) {

        int s = 1;
        int e = x;

        while (s <= e) {

            int mid = s + (e - s) / 2;

            long square = (long) mid * mid;

            if (square > x) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        return s - 1;
    }
}