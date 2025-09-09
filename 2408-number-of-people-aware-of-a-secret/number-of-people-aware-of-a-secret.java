class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long mod=(long)Math.pow(10,9)+7;
        long[] dp=new long[n+1];
        dp[1]=1;
        for(int i=1;i<=n;i++){
            for(int j=i+delay;j<=n && j<i+forget;j++){
                dp[j]=(dp[i]+dp[j])%mod;
            }
        }

        long ans=0;
        for(int i=n-forget+1;i<=n;i++){
            ans= (ans+dp[i])%mod;
        }

        return (int)ans;
    }
}