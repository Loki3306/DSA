class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int total=0;
        for(int p:cardPoints) total+=p;

        int window= n-k;
        int curr=0;
        for(int i=0;i<window;i++){
            curr+=cardPoints[i];
        }

        int minVal=curr;

        for(int i=window;i<n;i++){
            curr+=cardPoints[i];
            curr-=cardPoints[i-window];
            minVal=Math.min(minVal,curr);
        }

        return total-minVal;
    }
}