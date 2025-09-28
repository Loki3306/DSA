class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int ans=0;
        for(int i=n-1;i>=0;i--){
            int j=0,k=i-1;

            while(j<k){
                if(nums[j]+nums[k] > nums[i]){
                    ans=Math.max(ans,nums[i]+nums[j]+nums[k]);
                }

                j++;
            }
        }

        return ans;
    }
}