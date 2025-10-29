class Solution {
    public int smallestNumber(int n) {
        int bits = Integer.toBinaryString(n).length();
        String s = "1".repeat(bits);
        int num = Integer.parseInt(s, 2);
        if(num < n) {
            s = "1".repeat(bits + 1);
            num = Integer.parseInt(s, 2);
        }
        return num;
    }
}
