class Solution {
    public long flowerGame(int n, int m) {
        long a = (n + 1) / 2L * (m / 2);
        long b = (n / 2) * ((m + 1) / 2L);
        return a + b;
    }
}
