class Solution {
    public int maximum69Number(int num) {
        String s = String.valueOf(num);
        int idx = s.indexOf('6');
        if (idx == -1) return num;
        return Integer.parseInt(s.substring(0, idx) + "9" + s.substring(idx + 1));
    }
}
