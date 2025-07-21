class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low=0,high=0;
        int n=bloomDay.length;

        for(int i=0;i<n;i++){
            low=Math.min(low,bloomDay[i]);
            high=Math.max(high,bloomDay[i]);
        }
        int ans=-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(isValid(bloomDay,mid,m,k) == true){
                ans=mid;
                high=mid-1;
            }

            else{
                low=mid+1;
            }
        }

        return ans;
    }


    public boolean isValid(int[] arr,int mid,int m,int k){
        int count=0;
        int mainCount=0;
        for(int i=0;i<arr.length;i++){
            if(mid >= arr[i]){
                count++;
                if(count == k ){
                    mainCount++;
                    count=0;
                }
            }
            else{
                count=0;
            }
        }

        if(mainCount >= m) return true;

        return false;
    }


}