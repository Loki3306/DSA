class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans = 0;
        int ind = 0;
        while(ind<costs.length && coins>0 && costs[ind] <= coins){
            ans++;
            coins -= costs[ind++];
        }

        return ans;
    }
}