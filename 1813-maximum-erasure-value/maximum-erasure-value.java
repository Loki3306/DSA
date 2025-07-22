class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left=0,right=0,sum=0,max=Integer.MIN_VALUE;

        while(right<nums.length){
            while(set.contains(nums[right])){
                set.remove(nums[left]);
                sum-=nums[left];
                left++;
            }
            sum+=nums[right];
            max=Math.max(max,sum);
            set.add(nums[right]);
            right++;
        }
        max=Math.max(max,sum);

        return max;
    }
}
