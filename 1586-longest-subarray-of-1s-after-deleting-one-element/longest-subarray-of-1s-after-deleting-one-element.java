class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=nums[0];
        right[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            if(nums[i]==1){
                left[i]=left[i-1]+1;
            }else{
                left[i]=0;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(nums[i]==1){
                right[i]=right[i+1]+1;
            }else{
                right[i]=0;
            }
        }

        int ans=0;
        for(int i=0;i<n;i++){
            int leftE=(i > 0 ) ? left[i-1]:0;
            int rightE=(i < n-1 ) ? right[i+1]:0;
            ans=Math.max(ans,leftE+rightE);
        }

        return ans;
    }
}