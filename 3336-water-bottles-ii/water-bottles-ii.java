class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans=numBottles;
        int empty_bottles=numBottles;

        while(empty_bottles >= numExchange){
            ans++;
            empty_bottles= empty_bottles - numExchange + 1;
            numExchange++;
        }

        return ans;
    }
}