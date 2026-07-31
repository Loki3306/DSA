class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (int i = 0; i < word.length(); i++) {
            freq[word.charAt(i) - 'a']++;
        }

        int mult = 1;
        int ans = 0;
        int cnt = 0;
        int ind = 0;
        Arrays.sort(freq);

        for (int i = 0, j = freq.length - 1; i < j; i++, j--) {
            int temp = freq[i];
            freq[i] = freq[j];
            freq[j] = temp;
        }

        while (ind < 26) {
            ans += (mult * freq[ind]);
            cnt++;

            if (cnt == 8) {
                cnt = 0;
                mult++;
            }

            ind++;
        }

        return ans;
    }
}