class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int lpt = 0;
        int rpt = n-1;
        int[] ans = new int[2];

        while(lpt < rpt){
            int sum = nums[lpt] + nums[rpt];
            if(sum == target){
                ans[0] = lpt+1;
                ans[1] = rpt+1;
                return ans;
            }

            else if(sum < target) lpt++;
            else rpt--;
        }

        return ans;
    }
}