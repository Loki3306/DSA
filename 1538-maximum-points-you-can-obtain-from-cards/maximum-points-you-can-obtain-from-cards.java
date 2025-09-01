class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left=0;
        int total=0;
        
        for( int p : cardPoints ){
            total+=p;
        }

        int windowSize = cardPoints.length - k;
        int curr = 0;
        for(int i=0;i<windowSize;i++){
            curr+=cardPoints[i];
        }

        int minSum=curr;

        for(int right=windowSize;right<cardPoints.length;right++){
            curr+=cardPoints[right];
            curr-=cardPoints[right-windowSize];
            minSum=Math.min(minSum,curr);
        }


        return total - minSum;


    }
}