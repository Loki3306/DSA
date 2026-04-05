class Solution {
    public boolean judgeCircle(String moves) {
        int cnt1 = 0;
        int cnt2 = 0;

        for(int i=0;i<moves.length();i++){
            char ch = moves.charAt(i);
            if(ch == 'U') cnt1++;
            else if(ch == 'D') cnt1--;
            else if(ch == 'R') cnt2++;
            else cnt2--;
        }

        return cnt1==0 && cnt2==0;
    }
}