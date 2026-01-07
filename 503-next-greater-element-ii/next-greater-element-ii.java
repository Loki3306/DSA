class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        if(n <= 1 ) for(int i=0;i<n;i++) ans[i]=-1;

        for(int i=0;i<n;i++){
            int index=i+1;
            while(index%n != i){
                ans[i]=-1;
                if(nums[index%n]>nums[i]){
                    ans[i]=nums[index%n];
                    break;
                }
                index++;
            }
        }

        return ans;
    }
}