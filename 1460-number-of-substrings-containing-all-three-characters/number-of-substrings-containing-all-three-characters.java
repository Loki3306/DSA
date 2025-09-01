class Solution {
    public int numberOfSubstrings(String s) {
        int[] freq=new int[3];
        int cnt=0,left=0;

        for(int right=0;right<s.length();right++){
            freq[s.charAt(right) - 'a']++;

            while(freq[0] > 0 && freq[1]>0 && freq[2] >0){
                cnt+= (s.length()-right);
                freq[s.charAt(left)- 'a']--;
                left++;
            }
        }

        return cnt;
    }
}