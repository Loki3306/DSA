class Solution {
    public int maxProfit(int[] nums) {
        int profit=0;
        int maxProfit=0;
        int minterm=nums[0];

        for(int i=1;i<nums.length;i++){
            profit=nums[i]-minterm;
            maxProfit=Math.max(profit,maxProfit);
            minterm=Math.min(minterm,nums[i]);
        }

        return maxProfit;

    }
}