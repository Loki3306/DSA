class Solution {
    public int splitArray(int[] nums, int k) {
        int s=0,h=0;
        for(int i=0;i<nums.length;i++){
            s=Math.max(s,nums[i]);
            h+=nums[i];
        }

        while(s<=h){
            int mid=s+(h-s)/2;
            int subArrayCount=subArrayCount(nums,mid);

            if(subArrayCount <= k){
                h=mid-1;
            }

            else{
                s=mid+1;
            }
        }

        return s;
    }

    public int subArrayCount(int[] arr,int capacity){
        int sum=0;
        int count=1;

        for(int i=0;i<arr.length;i++){
            if(sum + arr[i] > capacity){
                count++;
                sum=arr[i];
            }

            else{
                sum+=arr[i];
            }
        }

        return count+0;
    }

}