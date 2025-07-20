class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);

        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                if (count > nums.length / 3 && !list.contains(candidate)) {
                    list.add(candidate);
                }
                candidate = nums[i];
                count = 1;
            }
        }

        if (count > nums.length / 3 && !list.contains(candidate)) {
            list.add(candidate);
        }

        return list;
    }
}
