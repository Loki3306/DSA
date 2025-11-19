class Solution {
    public int findFinalValue(int[] nums, int original) {
        
        int ans=original;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==ans){
                i=-1;
                ans*=2;
            }
        }

        return ans;
    }
}