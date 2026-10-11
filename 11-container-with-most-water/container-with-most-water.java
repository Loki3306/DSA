class Solution {
    public int maxArea(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;

        int ans = 0;

        while(left<right){
            if(nums[left] > nums[right]){
                ans = Math.max(ans, (right-left)*nums[right]);
                right--;
            }
            else{
                ans = Math.max(ans, (right-left)*nums[left]);
                left++;
            }
        }

        return ans;
    }
}