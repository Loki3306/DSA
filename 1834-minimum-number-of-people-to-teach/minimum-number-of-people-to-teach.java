import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        List<Set<Integer>> langs = new ArrayList<>();
        for (int[] l : languages) {
            Set<Integer> s = new HashSet<>();
            for (int x : l) s.add(x);
            langs.add(s);
        }
        Set<Integer> problem = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1, v = f[1] - 1;
            if (Collections.disjoint(langs.get(u), langs.get(v))) {
                problem.add(u);
                problem.add(v);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int cnt = 0;
            for (int u : problem) {
                if (!langs.get(u).contains(lang)) cnt++;
            }
            ans = Math.min(ans, cnt);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
