class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length+1][2][k+1];
        
        for(int i=0;i<=prices.length;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j] ,-1 );
            }
        }
        return f(0,1,k,prices,prices.length,dp);
    }

    public int f(int day,int buy,int cap,int[] prices,int n,int[][][] dp){
        if(day==n || cap==0) return 0;
        if(dp[day][buy][cap] != -1) return dp[day][buy][cap];

        if(buy==1){
            dp[day][buy][cap] = Math.max(
                -prices[day] + f(day+1,0,cap,prices,n,dp),
                0 + f(day+1,1,cap,prices,n,dp)
            );
        }
        else{
            dp[day][buy][cap] = Math.max(
                prices[day] + f(day+1,1,cap-1,prices,n,dp),
                f(day+1,0,cap,prices,n,dp)
            );
        }

        return dp[day][buy][cap];
    }
}