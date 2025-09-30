class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length - 1;
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            int coeff = binomMod10(n, i);
            sum = (sum + coeff * nums[i]) % 10;
        }
        return sum;
    }

    private int binomMod10(int n, int k) {
        int a = binomLucas(n, k, 2);
        int b = binomLucas(n, k, 5);
        return crt(a, b);
    }

    private int binomLucas(int n, int k, int p) {
        int res = 1;
        while (n > 0 || k > 0) {
            int ni = n % p;
            int ki = k % p;
            if (ki > ni) return 0;
            res = (res * binomSmall(ni, ki, p)) % p;
            n /= p;
            k /= p;
        }
        return res;
    }

    private int binomSmall(int n, int k, int p) {
        if (k == 0 || k == n) return 1;
        int num = 1, den = 1;
        for (int i = 0; i < k; i++) {
            num = (num * (n - i)) % p;
            den = (den * (i + 1)) % p;
        }
        return (num * modInverse(den, p)) % p;
    }

    private int modInverse(int a, int p) {
        for (int x = 1; x < p; x++) {
            if ((a * x) % p == 1) return x;
        }
        return 1;
    }

    private int crt(int a, int b) {
        for (int x = 0; x < 10; x++) {
            if (x % 2 == a && x % 5 == b) return x;
        }
        return 0;
    }
}
