class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 1; // First char is always valid
        sb.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == s.charAt(i - 1)) {
                cnt++;
            } else {
                cnt = 1; // reset counter on new char
            }

            if (cnt < 3) {
                sb.append(curr); // allow only up to 2 same chars
            }
        }

        return sb.toString();
    }
}
