class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans=numBottles;
        int empty_bottles=numBottles;

        while(empty_bottles >= numExchange){
            ans+= (empty_bottles)/numExchange;
            empty_bottles = (empty_bottles/numExchange) + (empty_bottles%numExchange);
        }

        return ans;
    }
}