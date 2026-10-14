class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum < 0 || sum > 9 * num) return "";

        StringBuilder sb = new StringBuilder(num);

        for (int i = 0; i < num; i++) {
            int dig = Math.min(9, sum);
            sb.append(dig);
            sum -= dig;
        }

        return sb.toString();
    }
}