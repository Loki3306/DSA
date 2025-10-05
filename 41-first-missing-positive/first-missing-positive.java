class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> set=new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }

        for(int i=1;i<=n;i++){
            if(!set.contains(i)) return i;
        }

        return nums[nums.length-1]+1;
    }
}