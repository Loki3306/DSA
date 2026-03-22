class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128];
        int left = 0, len = 0;

        for(int right=0;right<s.length();right++){
            left = Math.max(left,lastSeen[s.charAt(right)]);
            len = Math.max(len,right-left+1);
            lastSeen[s.charAt(right)] = right + 1;
        }

        return len;   
    }
}