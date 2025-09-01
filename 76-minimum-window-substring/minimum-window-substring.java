class Solution {
    public String minWindow(String s, String t) {
        if(s.length() ==0 || t.length()==0 || s.length() < t.length()) return "";

        int[] targetFreq=new int[128];
        for(char ch: t.toCharArray()) targetFreq[ch]++;

        int left=0,right=0,start=0;
        int minLen= Integer.MAX_VALUE;
        int reqLen=t.length();

        while(right < s.length()){
            char rChar=s.charAt(right);
            if(targetFreq[rChar] > 0) reqLen--;
            targetFreq[rChar]--;
            right++;

            while(reqLen == 0){
                if(minLen > right-left){
                    minLen=right-left;
                    start=left;
                }

                char lChar=s.charAt(left);
                targetFreq[lChar]++;
                if(targetFreq[lChar] > 0) reqLen++;
                left++;
            }

        }

        return minLen == Integer.MAX_VALUE ? "": s.substring(start,minLen+start);


    }
}