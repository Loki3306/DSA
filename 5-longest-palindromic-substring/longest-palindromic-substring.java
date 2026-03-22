class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1 ) return "";

        int start = 0, maxLen = 0;

        for(int i=0;i<s.length();i++){
            int odd = expand(s,i,i);
            int even = expand(s,i,i+1);

            int len = Math.max(odd,even);

            if(len > maxLen){
                maxLen = len;
                start = i - (len-1)/2;
            }
        }

        return s.substring(start, start+ maxLen);
    }

    public int expand(String s,int left,int right){
        while(left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))){
            left--;
            right++;
        }

        return right - left - 1;
    }
}