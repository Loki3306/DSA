class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[128]; // last seen index + 1
        int maxLen = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            left = Math.max(left, index[s.charAt(right)]);
            maxLen = Math.max(maxLen, right - left + 1);
            index[s.charAt(right)] = right + 1;
        }

        return maxLen;
    }
}

