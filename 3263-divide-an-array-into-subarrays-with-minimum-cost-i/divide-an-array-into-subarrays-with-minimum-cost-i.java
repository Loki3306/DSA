class Solution {
    public int minimumCost(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int idx1 = -1;
        int idx2 = -1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i] < min1){
                min2 = min1;
                idx2 = idx1;
                min1 = nums[i];
                idx1 = i;
            } else if(nums[i] < min2){
                min2 = nums[i];
                idx2 = i;
            }
        }

        return nums[0] + min1 + min2;
    }
}
