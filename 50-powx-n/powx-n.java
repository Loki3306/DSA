class Solution {
    public double myPow(double x, int n) {
        long exp = n; // use long to avoid overflow
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }
        return power(x, exp);
    }

    private double power(double x, long n) {
        if (n == 0) return 1;
        double half = power(x, n / 2);
        if (n % 2 == 0) return half * half;
        else return half * half * x;
    }
}
