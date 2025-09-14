import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashSet<String> exact = new HashSet<>();
        HashMap<String, String> caseMap = new HashMap<>();
        HashMap<String, String> vowelMap = new HashMap<>();

        for (String w : wordlist) {
            exact.add(w);
            String lower = w.toLowerCase();
            caseMap.putIfAbsent(lower, w);
            String devoweled = devowel(lower);
            vowelMap.putIfAbsent(devoweled, w);
        }

        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q)) {
                ans[i] = q;
            } else {
                String lower = q.toLowerCase();
                if (caseMap.containsKey(lower)) {
                    ans[i] = caseMap.get(lower);
                } else {
                    String devoweled = devowel(lower);
                    ans[i] = vowelMap.getOrDefault(devoweled, "");
                }
            }
        }
        return ans;
    }

    private String devowel(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }
}
