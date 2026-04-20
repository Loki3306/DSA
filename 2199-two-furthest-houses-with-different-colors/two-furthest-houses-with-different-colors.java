class Solution {
    public int maxDistance(int[] nums) {
        int n = nums.length;
        int left = n - 1;
        while(left >=0 && nums[left] == nums[0]) left--;
        int right = 0;
        while(right < n && nums[right] == nums[n-1]) right++;

        return Math.max(left,n-right-1);
    }
}