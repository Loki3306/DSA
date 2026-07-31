class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int[][] dp = new int[n + 1][n + 1];

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int prev = ind - 1; prev >= -1; prev--) {
                int notTake = dp[ind+1][prev+1];
                int take = 0;
                if (prev == -1
                        || ((words[ind].length() == words[prev].length() + 1) && check(words[ind], words[prev]))) {
                    take = 1 + dp[ind+1][ind+1];

                }

                dp[ind][prev + 1] = Math.max(take, notTake);
            }
        }

        return dp[0][0];
    }

    // public int f(int ind, int prev, String[] words, int[][] dp) {
    //     if (ind == words.length)
    //         return 0;
    //     if (dp[ind][prev + 1] != -1)
    //         return dp[ind][prev + 1];

    //     int notTake = f(ind + 1, prev, words, dp);
    //     int take = 0;
    //     if (prev == -1 || ((words[ind].length() == words[prev].length() + 1) && check(words[ind], words[prev]))) {
    //         take = 1 + f(ind + 1, ind, words, dp);

    //     }

    //     return dp[ind][prev + 1] = Math.max(take, notTake);
    // }

    public boolean check(String curr, String prev) {
        int ptr1 = 0;
        int ptr2 = 0;
        int cnt = 0;
        while (ptr1 < curr.length() && ptr2 < prev.length()) {
            if (curr.charAt(ptr1) == prev.charAt(ptr2)) {
                ptr1++;
                ptr2++;
            } else {
                cnt++;
                if (cnt == 2)
                    return false;
                ptr1++;
            }
        }

        return true;
    }
}