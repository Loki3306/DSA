class Solution {
    public int maximum69Number(int num) {
        int n = num;
        int pos = -1;   // position of leftmost 6 (counting from right, 0-based)
        int idx = 0;
        
        // Scan digits from right to left
        while (n > 0) {
            if (n % 10 == 6) pos = idx;
            n /= 10;
            idx++;
        }
        
        // If no 6 found, return original
        if (pos == -1) return num;
        
        // Add the difference (9 - 6) * 10^pos = 3 * 10^pos
        return num + 3 * (int)Math.pow(10, pos);
    }
}
