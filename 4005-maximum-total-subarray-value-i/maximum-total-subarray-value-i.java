class Solution {
    public long maxTotalValue(int[] nums, int k) {
        Arrays.sort(nums);

        return (long)Math.abs(nums[nums.length-1] - nums[0])*k;
    }
}