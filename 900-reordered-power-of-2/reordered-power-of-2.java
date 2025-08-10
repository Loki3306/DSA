class Solution {
    public boolean reorderedPowerOf2(int n) {
        String s = sortDigits(n);
        for (int i = 0; i < 31; i++) {
            if (s.equals(sortDigits(1 << i))) return true;
        }
        return false;
    }

    private String sortDigits(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
