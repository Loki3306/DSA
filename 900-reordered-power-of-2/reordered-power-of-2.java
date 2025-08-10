class Solution {
    static Set<String> powerSignatures = new HashSet<>();
    static {
        for (int i = 0; i < 31; i++) {
            powerSignatures.add(signature(1 << i));
        }
    }

    public boolean reorderedPowerOf2(int n) {
        return powerSignatures.contains(signature(n));
    }

    private static String signature(int n) {
        int[] count = new int[10];
        while (n > 0) {
            count[n % 10]++;
            n /= 10;
        }
        return Arrays.toString(count);
    }
}
