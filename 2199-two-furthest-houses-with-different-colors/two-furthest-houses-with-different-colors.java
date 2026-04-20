class Solution {
    public int maxDistance(int[] nums) {
        int maxM = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i=0;i<n-1;i++){
            int index = n-1;

            while(index >= i && nums[index] == nums[i]) index--;

            maxM = Math.max(maxM,Math.abs(index-i));
        }

        return maxM;
    }
}