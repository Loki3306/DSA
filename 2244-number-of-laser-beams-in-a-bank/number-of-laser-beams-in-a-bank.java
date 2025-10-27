class Solution {
    public int numberOfBeams(String[] bank) {
        int ans=0;
        int prev=0;
        int n=bank.length;
        for(int i=0;i<n;i++){
            String s=bank[i];
            int ones=0;
            int len=s.length();
            for(int j=0;j<len;j++){
                if(s.charAt(j)=='1') ones++;
            }
            if(ones>0){
                ans+=prev*ones;
                prev=ones;
            }
        }
        return ans;
    }
}
