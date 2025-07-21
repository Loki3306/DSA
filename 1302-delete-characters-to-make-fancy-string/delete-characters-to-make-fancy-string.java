class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        char prev = s.charAt(0);
        int count = 1;
        sb.append(prev);

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            count = (curr == prev) ? count + 1 : 1;

            if (count < 3) sb.append(curr);
            prev = curr;
        }

        return sb.toString();
    }
}
