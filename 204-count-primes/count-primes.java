class Solution {
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;

        int[] map = new int[n];
        for (int i = 2; i < n; i++) {
            map[i] = 1;
        }

        for (int i = 2; i * i < n; i++) {
            if (map[i] == 1) {
                for (int j = i * i; j < n; j += i) {
                    map[j] = 0;
                }
            }
        }

        int sum = 0;
        for (int i = 2; i < n; i++) {
            sum += map[i];
        }

        return sum;
    }
}
