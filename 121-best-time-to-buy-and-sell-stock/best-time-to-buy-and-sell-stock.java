class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int maxProfit = Integer.MIN_VALUE;
        int min = prices[0];

        for(int i=0;i<prices.length;i++){
            profit = prices[i] - min;
            min = Math.min(prices[i],min);
            maxProfit = Math.max(profit,maxProfit);
        }


        return maxProfit;
    }
}