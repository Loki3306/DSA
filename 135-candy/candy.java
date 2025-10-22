class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] candies=new int[n];
        Arrays.fill(candies,1);
        int cnt=n;
        for(int i=1;i<n;i++){
            if(ratings[i] > ratings[i-1] ){ 
                cnt -= candies[i];
                candies[i]=candies[i-1]+1;
                cnt += candies[i];
            }
        }

        for(int i=n-2;i>=0;i--){
            if(ratings[i] > ratings[i+1] ){
             cnt -= candies[i];   
             candies[i]=Math.max(candies[i], candies[i+1] +1);
             cnt += candies[i];
            }
        }


        return cnt;
    }
}