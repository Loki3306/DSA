class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int cnt = 1;
        int max = 1;
        for(int i=1;i<n;i++){
            if(nums[i] > nums[i-1]) cnt++;
            else cnt = 1;

            max = Math.max(max,cnt);
        }

        return max;
    }
}