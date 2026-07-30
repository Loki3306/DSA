class Solution {
    public int minimumPushes(String word) {
        int cnt = 0,ind = 0;
        int val = 1;
        int ans = 0;
        int len = word.length();

        while(ind < len){
            ans += val;
            cnt ++;
            if(cnt == 8){
                val++;
                cnt = 0;
            }
            ind++;
        }

        return ans;
    }
}