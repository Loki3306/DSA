class Solution {
    public int findFinalValue(int[] nums, int original) {
        
        

        for(int i=0;i<nums.length;i++){
            if(nums[i]==original){
                i=-1;
                original*=2;
            }
        }

        return original;
    }
}